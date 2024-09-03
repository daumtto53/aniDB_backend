package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.UpvotedSeriesComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpvotedSeriesCommentMapper {
    UpvotedSeriesComment selectUpvotedSeriesCommentById(@Param("memberId") Long memberId, @Param("commentId") Long commentId);
    UpvotedSeriesComment selectUpvotedSeriesComment(Long memberId, Long commentId);

    int insertUpvotedSeriesComment(UpvotedSeriesComment upvotedSeriesComment);
    int deleteUpvotedSeriesComment(UpvotedSeriesComment upvotedSeriesComment);

    int deleteUpvotedSeriesCommentByCommentId(@Param("commentId") Long commentId);


}
