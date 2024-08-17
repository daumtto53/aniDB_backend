package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.RelatedSeries;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RelatedSeriesMapper {
    RelatedSeries getRelatedSeriesById(Long relatedPublicationId, Long publicationId);
    List<RelatedSeries> getRelatedSeriesByPublicationId(Long publicationId);
    int insertRelatedSeries(RelatedSeries relatedSeries);
    int updateRelatedSeries(RelatedSeries relatedSeries);
    int deleteRelatedSeries(@Param("relatedPublicationId") Long relatedPublicationId, @Param("publicationId") Long publicationId);
}