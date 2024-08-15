package com.aniDB.aniDB_backend.entity;

import lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedComment {
    private Integer memberId;
    private Integer commentId;
    private Integer upvotedNumber;
}