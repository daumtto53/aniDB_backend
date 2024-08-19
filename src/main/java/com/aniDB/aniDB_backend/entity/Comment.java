package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Long commentId;
    private Long memberId;
    private Long articleId;
    private String content;
    private Long upvotes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}