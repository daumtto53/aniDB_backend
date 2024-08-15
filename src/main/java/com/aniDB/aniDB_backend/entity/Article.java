package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Article {
    private Integer articleId;
    private Integer memberId;
    private String title;
    private String content;
    private Integer views;
    private Integer seriesId;
    private Integer upvotes;
}