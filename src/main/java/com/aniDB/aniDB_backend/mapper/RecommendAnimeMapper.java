package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.RecommendAnime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    UNCHECKED
 */
@Mapper
public interface RecommendAnimeMapper {

    void insertRecommendAnime(RecommendAnime recommendAnime);

    RecommendAnime selectRecommendAnimeById(int memberId, int animeId);

    void updateRecommendAnime(RecommendAnime recommendAnime);

    void deleteRecommendAnime(int memberId, int animeId);

    List<RecommendAnime> selectAllRecommendAnime();
}
