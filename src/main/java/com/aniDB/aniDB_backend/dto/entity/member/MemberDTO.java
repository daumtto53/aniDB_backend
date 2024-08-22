package com.aniDB.aniDB_backend.dto.entity.member;

import com.aniDB.aniDB_backend.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberDTO {
    private Long memberId;
    private String loginId;
    private String name;
    private String nickname;
}
