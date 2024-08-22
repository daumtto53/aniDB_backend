package com.aniDB.aniDB_backend.dto.entity.anime_adaptation;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnimeAdaptationDTO {
    private Long animeId;
    //anime_type를 추후에는 이름(String으로 )
    private  Integer animeType;
    private String animeName;
    private  Integer publicationStart;
    private  Integer publicationEnd;
    private  Integer animeStart;
    private  Integer animeEnd;
}
