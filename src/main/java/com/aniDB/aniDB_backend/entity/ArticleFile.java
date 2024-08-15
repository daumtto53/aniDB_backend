package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleFile {
    private Integer articleId;
    private Integer memberId;
    private String originalFilename;
    private String savedFilename;
    private Integer size;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}