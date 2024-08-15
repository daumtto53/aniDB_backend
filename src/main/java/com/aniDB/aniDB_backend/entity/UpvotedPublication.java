package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedPublication {
    private Integer memberId;
    private Integer publicationId;
    private Integer upvotedNumber;
}