package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.series_comment.SeriesCommentDTO;
import com.aniDB.aniDB_backend.entity.SeriesComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SeriesCommentMapper {
    // Series Comment operations
    int insertSeriesComment(SeriesComment seriesComment);
    List<SeriesComment> selectSeriesCommentsByPublicationId(Long publicationId);
    List<SeriesCommentDTO> selectSeriesCommentDTOByPublicationId(Long publicationId);
    int updateSeriesComment(SeriesComment seriesComment);
    int deleteSeriesComment(Long seriesCommentId);

    SeriesComment findById(Long seriesCommentId);
}
