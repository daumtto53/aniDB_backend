package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedSeriesComment {
    private Long memberId;
    private Long commentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}