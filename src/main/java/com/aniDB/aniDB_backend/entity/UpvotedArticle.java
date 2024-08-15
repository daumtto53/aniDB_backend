package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedArticle {
    private Integer memberId;
    private Integer articleId;
    private Integer upvotedNumber;
}