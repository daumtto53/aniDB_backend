package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendPublication {
    private Integer memberId;
    private Integer publicationId;
    private String discussion;
}