package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Comment;
import com.aniDB.aniDB_backend.mapper.CommentMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    private final CommentMapper commentMapper;

    public CommentRepository(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public Comment findById(Long commentId) {
        return commentMapper.selectCommentById(commentId);
    }

    public List<Comment> findAllByArticleId(Long articleId) {
        return commentMapper.selectAllCommentsByArticleId(articleId);
    }

    public int save(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    public int update(Comment comment) {
        return commentMapper.updateComment(comment);
    }

    public int deleteById(Long commentId) {
        return commentMapper.deleteCommentById(commentId);
    }
}