package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.UpvotedComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpvotedCommentMapper {

    UpvotedComment selectUpvotedCommentById(@Param("memberId") Long memberId, @Param("commentId") Long commentId);

    int insertUpvotedComment(UpvotedComment upvotedComment);

    int deleteUpvotedComment(@Param("memberId") Long memberId, @Param("commentId") Long commentId);
}