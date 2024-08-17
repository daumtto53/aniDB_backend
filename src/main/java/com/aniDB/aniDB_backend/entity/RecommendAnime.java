package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendAnime {
    private Long memberId;
    private Long animeId;
    private String discussion;
}