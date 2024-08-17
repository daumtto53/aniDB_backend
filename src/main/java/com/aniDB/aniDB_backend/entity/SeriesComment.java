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
    Long publicationId;
    Long memberId;
    String anidbComment;
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
