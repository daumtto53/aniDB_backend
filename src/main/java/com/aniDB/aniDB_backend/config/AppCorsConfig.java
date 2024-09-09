package com.aniDB.aniDB_backend.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@Log4j2
public class AppCorsConfig implements WebMvcConfigurer {

    @Value("${client-endpoint}")
    private String endpointURI;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
//                .allowedOrigins(endpointURI, "http://frontend-container:5173" )
                .allowedOrigins(endpointURI, "http://ec2-13-125-60-243.ap-northeast-2.compute.amazonaws.com:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders("Set-Cookie");
        log.info("allowed cors origin = {}", endpointURI);
    }
}
