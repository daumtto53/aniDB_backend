package com.aniDB.aniDB_backend.dto.entity.member;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class BasicRegisterMemberDTO {
    private Long memberId;
    private String username;
    private String loginId;
    private String member_password;
    @Builder.Default
    private boolean isFromSocial = false;
}
