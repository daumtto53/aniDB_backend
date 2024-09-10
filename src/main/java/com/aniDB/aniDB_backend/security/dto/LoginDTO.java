package com.aniDB.aniDB_backend.security.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDTO {
        private String username;
        private String password;
}
