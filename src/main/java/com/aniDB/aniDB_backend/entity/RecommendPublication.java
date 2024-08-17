package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendPublication {
    private Long memberId;
    private Long publicationId;
    private String discussion;
}