package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.mapper.UpvotedCommentMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UpvotedCommentRepository {

    private final UpvotedCommentMapper upvotedCommentMapper;

    public UpvotedCommentRepository(UpvotedCommentMapper upvotedCommentMapper) {
        this.upvotedCommentMapper = upvotedCommentMapper;
    }

    public UpvotedComment findById(Long memberId, Long commentId) {
        return upvotedCommentMapper.selectUpvotedCommentById(memberId, commentId);
    }

    public UpvotedComment find(Long memberId, Long commentId) {
        return upvotedCommentMapper.selectUpvotedCommentById(memberId, commentId);
    }

    public int save(UpvotedComment upvotedComment) {
        return upvotedCommentMapper.insertUpvotedComment(upvotedComment);
    }

    public int delete(UpvotedComment upvotedComment) {
        return upvotedCommentMapper.deleteUpvotedComment(upvotedComment);
    }

    public int deleteByCommentId(Long commentId) {
        return upvotedCommentMapper.deleteUpvotedCommentByCommentId(commentId);
    }
}