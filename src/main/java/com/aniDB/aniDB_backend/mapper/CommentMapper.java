package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {

    Comment selectCommentById(@Param("commentId") Long commentId);

    List<Comment> selectAllCommentsByArticleId(@Param("articleId") Long articleId);

    int insertComment(Comment comment);

    int updateComment(Comment comment);

    int deleteCommentById(@Param("commentId") Long commentId);
}