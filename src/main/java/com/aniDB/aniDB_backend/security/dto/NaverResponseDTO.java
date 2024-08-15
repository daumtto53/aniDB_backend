package com.aniDB.aniDB_backend.security.dto;

import lombok.Getter;

import java.util.Map;

//
@Getter
public class NaverResponseDTO implements OAuth2Response{

    private String provider;
    private String providerId;
    private String email;
    private String name;

    public NaverResponseDTO(Map<String, Object> attribute){
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        this.provider = "naver";
        this.providerId = response.get("id").toString();
        this.email = response.get("email").toString();
        this.name = response.get("name").toString();
    }
}
