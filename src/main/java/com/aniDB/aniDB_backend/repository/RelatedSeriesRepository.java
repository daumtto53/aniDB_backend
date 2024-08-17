package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.RelatedSeries;
import com.aniDB.aniDB_backend.mapper.RelatedSeriesMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RelatedSeriesRepository {

    private final RelatedSeriesMapper relatedSeriesMapper;

    public RelatedSeriesRepository(RelatedSeriesMapper relatedSeriesMapper) {
        this.relatedSeriesMapper = relatedSeriesMapper;
    }

    public RelatedSeries getRelatedSeriesById(Long relatedPublicationId, Long publicationId) {
        return relatedSeriesMapper.getRelatedSeriesById(relatedPublicationId, publicationId);
    }

    public List<RelatedSeries> getRelatedSeriesByPublicationId(Long publicationId) {
        return relatedSeriesMapper.getRelatedSeriesByPublicationId(publicationId);
    }

    public int createRelatedSeries(RelatedSeries relatedSeries) {
        return relatedSeriesMapper.insertRelatedSeries(relatedSeries);
    }

    public int updateRelatedSeries(RelatedSeries relatedSeries) {
        return relatedSeriesMapper.updateRelatedSeries(relatedSeries);
    }

    public int deleteRelatedSeries(Long relatedPublicationId, Long publicationId) {
        return relatedSeriesMapper.deleteRelatedSeries(relatedPublicationId, publicationId);
    }
}