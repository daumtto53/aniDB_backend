package com.aniDB.aniDB_backend.security.dto;

import lombok.Getter;

import java.util.Map;

@Getter
public class GoogleResponseDTO implements OAuth2Response {

    private String provider;
    private String providerId;
    private String name;
    private String email;
    private String nickname;
    private String profileImageUrl;

    public GoogleResponseDTO(Map<String, Object> attribute){
        this.provider = "google";
        this.providerId = attribute.get("sub").toString();
        this.email = attribute.get("email").toString();
        this.name = attribute.get("name").toString();
        this.nickname = attribute.get("given_name") != null ? attribute.get("given_name").toString() : null;
        this.profileImageUrl = attribute.get("picture") != null ? attribute.get("picture").toString() : null;
//        this.gender = response.get("gender") != null ? response.get("gender").toString() : null;
//        this.birthday = response.get("birthday") != null ? response.get("birthday").toString() : null;
//        this.birthYear = response.get("birthyear") != null ? response.get("birthyear").toString() : null;
    }
}
