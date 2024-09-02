package com.aniDB.aniDB_backend.security.dto;

import lombok.Getter;

import java.util.Map;

//
@Getter
public class NaverResponseDTO implements OAuth2Response{

    private String provider;
    private String providerId;
    private String name;
    private String email;
    private String nickname;
    private String profileImageUrl;
    private String gender;
    private String birthday;
    private String birthYear;

    public NaverResponseDTO(Map<String, Object> attribute){
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        this.provider = "naver";
        this.providerId = response.get("id").toString();
        this.email = response.get("email").toString();
        this.name = response.get("name").toString();
        this.nickname = response.get("nickname") != null ? response.get("nickname").toString() : null;
        this.profileImageUrl = response.get("profile_image") != null ? response.get("profile_image").toString() : null;
//        this.gender = response.get("gender") != null ? response.get("gender").toString() : null;
//        this.birthday = response.get("birthday") != null ? response.get("birthday").toString() : null;
//        this.birthYear = response.get("birthyear") != null ? response.get("birthyear").toString() : null;
    }
}
