package com.aniDB.aniDB_backend.entity;

import lombok.*;

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
    private  Integer publicationStart;
    private  Integer publicationEnd;
    private  Integer animeType;
    private  Integer animeStart;
    private  Integer animeEnd;
}
