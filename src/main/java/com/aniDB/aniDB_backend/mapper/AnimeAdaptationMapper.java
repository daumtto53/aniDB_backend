package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AnimeAdaptation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AnimeAdaptationMapper {
    int insert(AnimeAdaptation record);
    AnimeAdaptation selectByAnimeAdaptationId(Long animeAdaptationId);
    int update(AnimeAdaptation record);
    int delete(Long animeAdaptationId);
}
