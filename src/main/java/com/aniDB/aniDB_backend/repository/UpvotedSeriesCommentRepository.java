package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.UpvotedSeriesComment;
import com.aniDB.aniDB_backend.entity.UpvotedSeriesComment;
import com.aniDB.aniDB_backend.mapper.UpvotedSeriesCommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UpvotedSeriesCommentRepository {
    private final UpvotedSeriesCommentMapper upvotedCommentMapper;

    public UpvotedSeriesComment findById(Long memberId, Long commentId) {
        return upvotedCommentMapper.selectUpvotedSeriesCommentById(memberId, commentId);
    }

    public UpvotedSeriesComment find(Long memberId, Long commentId) {
        return upvotedCommentMapper.selectUpvotedSeriesCommentById(memberId, commentId);
    }

    public int save(UpvotedSeriesComment upvotedComment) {
        return upvotedCommentMapper.insertUpvotedSeriesComment(upvotedComment);
    }

    public int delete(UpvotedSeriesComment upvotedComment) {
        return upvotedCommentMapper.deleteUpvotedSeriesComment(upvotedComment);
    }

    public int deleteByCommentId(Long commentId) {
        return upvotedCommentMapper.deleteUpvotedSeriesCommentByCommentId(commentId);
    }
}
