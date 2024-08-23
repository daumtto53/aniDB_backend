package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeriesComment {
    private Long seriesCommentId;
    private Long publicationId;
    private Long memberId;
    private String anidbComment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
