package com.aniDB.aniDB_backend.dto.entity.series_comment;

import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeriesCommentDTO {
    private Long seriesCommentId;
    private Long publicationId;
    private Long memberId;
    private MemberDTO memberDTO;
    private String anidbComment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
