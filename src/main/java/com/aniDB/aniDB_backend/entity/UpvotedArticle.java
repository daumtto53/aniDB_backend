package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedArticle {
    private Long memberId;
    private Long articleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}