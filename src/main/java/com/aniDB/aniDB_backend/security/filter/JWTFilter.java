package com.aniDB.aniDB_backend.security.filter;

import com.aniDB.aniDB_backend.security.dto.OAuth2UserDTO;
import com.aniDB.aniDB_backend.security.model.CustomOAuth2User;
import com.aniDB.aniDB_backend.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = null;
        String authorizationToken = extractAuthorizationTokenFromCookie(request);

        /*
            authorizationToken 처리
         */
        if (authorizationToken == null) {
            log.info("token null");
            filterChain.doFilter(request, response);
            return ;
        }
        if (jwtUtils.isExpired(authorizationToken)) {
            log.error("jwt token is expired");
            filterChain.doFilter(request, response);
            return ;
        }

        /*
            authentication을 만들어서 securityContext에 추가.
         */
        OAuth2UserDTO userDTO = getOAuth2UserFromJWT(authorizationToken);
        CustomOAuth2User customOAuth2User = new CustomOAuth2User(userDTO);

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(
                        customOAuth2User, null, customOAuth2User.getAuthorities()
                );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }

    private OAuth2UserDTO getOAuth2UserFromJWT(String authorizationToken) {
        String username = jwtUtils.getUsername(authorizationToken);
        List<String> roles = jwtUtils.getRole(authorizationToken);
        return (OAuth2UserDTO.builder()
                .username(username)
                .roles(roles)
                .build());
    }


    private String extractAuthorizationTokenFromCookie(HttpServletRequest request) {
        String authorization = null;
        Cookie cookies[] = request.getCookies();
        if (cookies == null) return null;
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("Authorization")) {
                authorization = cookie.getValue();
            }
        }
        return authorization;
    }
}
