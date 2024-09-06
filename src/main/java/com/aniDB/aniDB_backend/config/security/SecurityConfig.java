package com.aniDB.aniDB_backend.config.security;

import com.aniDB.aniDB_backend.security.filter.JWTFilter;
import com.aniDB.aniDB_backend.security.handler.CustomAuthenticationEntryPoint;
import com.aniDB.aniDB_backend.security.handler.CustomSuccessHandler;
import com.aniDB.aniDB_backend.security.service.CustomOAuth2UserService;
import com.aniDB.aniDB_backend.utils.JWTUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.web.OAuth2LoginAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
@Log4j2
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomSuccessHandler customSuccessHandler;
    private final JWTUtils jwtUtils;
    private final JWTFilter jwtFilter;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Value("${client-endpoint}")
    private String client_uri;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(c -> c.disable());
        http.formLogin(c -> c.disable());
        http.httpBasic(c -> c.disable());

        // Security Logic 이 닿는 모든 곳에 Security 설정.
        http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(
                new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(Collections.singletonList(client_uri));
                        log.info("allowed Cors origins = {}", client_uri);
                        configuration.setAllowedMethods(Collections.singletonList("*"));
                        configuration.setAllowCredentials(true);
                        configuration.setAllowedHeaders(Collections.singletonList("*"));
                        configuration.setMaxAge(3600L);
                        configuration.setExposedHeaders(Collections.unmodifiableList(
                                Arrays.asList("Set-Cookie", "Authorization")
                        ));
                        return configuration;
                    }
                }
        ));

        // JWTFilter -> OAuth2RedirectionFilter -> OAuth2LoginAuthFilter 의 순서로 진행.
        http.addFilterAfter(jwtFilter, OAuth2LoginAuthenticationFilter.class);

        // Login logic. UserInfo Endpoint를 설정한다. Login 성공 시, SuccessHandler를 설정한다.
        http.oauth2Login(configurer -> {
            configurer.userInfoEndpoint(
                    userInfoEndpointConfig -> userInfoEndpointConfig
                            .userService(customOAuth2UserService)
                    )
                    .successHandler(customSuccessHandler)
                    .failureHandler((request, response, exception) ->
                            customAuthenticationEntryPoint.commence(request,response,exception)
                    );
        });

        // Security Authorize 실패 시, failHandler.
        http.exceptionHandling(configurer ->
                configurer.authenticationEntryPoint(customAuthenticationEntryPoint)
        );

        //Logout 시 Cookie삭제.
        http.logout(config -> config.logoutUrl("/api/logout")
                .deleteCookies("Authorization")
                .logoutSuccessHandler((request, response, authentication) ->
                        response.setStatus(HttpServletResponse.SC_OK)
                )
        );

        // URL Mapping Security
        http.authorizeHttpRequests(customizer -> customizer
                .requestMatchers("/**").permitAll()
        );
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
}
