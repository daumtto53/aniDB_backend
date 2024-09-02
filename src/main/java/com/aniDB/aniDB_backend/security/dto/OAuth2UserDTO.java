package com.aniDB.aniDB_backend.security.dto;

import lombok.*;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OAuth2UserDTO {
    private String username;
    private String email;
    private String name;

    private List<String> roles;
}
