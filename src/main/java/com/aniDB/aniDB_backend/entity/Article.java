package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {
    private Long articleId;
    private Long memberId;
    private Long publicationId;
    private Long animeId;
    private String title;
    private String content;
    @Builder.Default
    private Integer views = 0;
    private Long seriesId;
    @Builder.Default
    private Integer upvotes = 0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}