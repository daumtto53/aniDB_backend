package com.aniDB.aniDB_backend.dto.entity.comment;

import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDTO {
    private Long commentId;
    private MemberDTO memberDTO;
    private Long articleId;
    private String content;
    private Long upvotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}