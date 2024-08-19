package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.AnimeAdaptation;
import com.aniDB.aniDB_backend.mapper.AnimeAdaptationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnimeAdaptationRepository {

    private final AnimeAdaptationMapper animeAdaptationMapper;

    public int insert(AnimeAdaptation animeAdaptation) {
        return animeAdaptationMapper.insert(animeAdaptation);
    }

    public AnimeAdaptation findByPrimaryKey(Long animeAdaptationId) {
        return animeAdaptationMapper.selectByAnimeAdaptationId(animeAdaptationId);
    }

    public int update(AnimeAdaptation animeAdaptation) {
        return animeAdaptationMapper.update(animeAdaptation);
    }

    public int delete(Long animeAdaptationId) {
        return animeAdaptationMapper.delete(animeAdaptationId);
    }
}
