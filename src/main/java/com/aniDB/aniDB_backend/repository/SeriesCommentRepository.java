package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.series_comment.SeriesCommentDTO;
import com.aniDB.aniDB_backend.entity.SeriesComment;
import com.aniDB.aniDB_backend.mapper.SeriesCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SeriesCommentRepository {
    private final SeriesCommentMapper seriesCommentMapper;

    public int insertSeriesComment(SeriesComment seriesComment) {
        return seriesCommentMapper.insertSeriesComment(seriesComment);
    }

    public SeriesComment findById(Long seriesCommentId) {
        return seriesCommentMapper.findById(seriesCommentId);
    }

    public List<SeriesComment> selectSeriesCommentsByPublicationId(Long publicationId) {
        return seriesCommentMapper.selectSeriesCommentsByPublicationId(publicationId);
    }
    public List<SeriesCommentDTO> selectSeriesCommentDTOByPublicationId(Long publicationId) {
        return seriesCommentMapper.selectSeriesCommentDTOByPublicationId(publicationId);
    }

    public int updateSeriesComment(SeriesComment seriesComment) {
        return seriesCommentMapper.updateSeriesComment(seriesComment);
    }

    public int deleteSeriesComment(Long seriesCommentId) {
        return seriesCommentMapper.deleteSeriesComment(seriesCommentId);
    }


}
