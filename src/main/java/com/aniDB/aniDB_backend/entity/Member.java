package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private Long memberId;
    private String username;
    private String loginId;
    private String password;
    private String email;
    private Boolean isFromSocial;
    private Boolean isDisabled;
    private String name;
    private String nickname;
    private LocalDateTime birthday;
    private String gender;  // Assuming values like "MALE" or "FEMALE"
    private String description;
}