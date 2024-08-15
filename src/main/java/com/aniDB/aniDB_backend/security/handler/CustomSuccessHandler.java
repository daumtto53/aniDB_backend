package com.aniDB.aniDB_backend.security.handler;

import com.aniDB.aniDB_backend.security.model.CustomOAuth2User;
import com.aniDB.aniDB_backend.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Log4j2
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final JWTUtils jwtUtils;

    //Client / Frontend Endpoint
    @Value("${client-endpoint}")
    private String client_uri;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        String username = customOAuth2User.getName();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roleList = authorities.stream().map(
                grantedAuthority -> grantedAuthority.getAuthority()
        ).collect(Collectors.toList());

        String token = jwtUtils.createJWT(username, roleList, 60*60*60*24L);
        response.addCookie(createCookie("Authorization", token));
        response.sendRedirect(client_uri);
    }

    private Cookie createCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60*60*60*24);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        return cookie;
    }
}
