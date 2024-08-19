package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnimeAdaptation {
    private  Long animeAdaptationId;
    private  Long publicationId;
    private  Long animeId;
    private String animeName;
    private  Integer publicationStart;
    private  Integer publicationEnd;
    private  Integer animeType;
    private  Integer animeStart;
    private  Integer animeEnd;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
