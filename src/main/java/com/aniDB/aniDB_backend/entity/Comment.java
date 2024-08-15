package com.aniDB.aniDB_backend.entity;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    private Integer commentId;
    private Integer memberId;
    private Integer articleId;
    private String content;
    private Integer upvotes;
}