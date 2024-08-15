package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendAnime {
    private Integer memberId;
    private Integer animeId;
    private String discussion;
}