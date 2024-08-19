package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpvotedPublication {
    private Long memberId;
    private Long publicationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}