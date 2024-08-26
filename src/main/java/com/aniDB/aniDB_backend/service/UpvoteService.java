package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.repository.UpvotedArticleRepository;
import com.aniDB.aniDB_backend.repository.UpvotedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UpvoteService {

    private final UpvotedCommentRepository upvotedCommentRepository;
    private final UpvotedArticleRepository upvotedArticleRepository;

    //TEMPORARY ID
    private Long tempMemberId = 60L;

    public void upvoteArticle(Long articleId) {
        UpvotedArticle upvotedArticle = UpvotedArticle.builder()
                .memberId(tempMemberId)
                .articleId(articleId)
                .build();
        upvotedArticleRepository.save(upvotedArticle);
    }

    public void cancelUpvoteArticle(Long articleId) {
        UpvotedArticle upvotedArticle = UpvotedArticle.builder()
                .memberId(tempMemberId)
                .articleId(articleId)
                .build();
        upvotedArticleRepository.delete(upvotedArticle);
    }

    public void upvoteComment(Long commentId) {
        UpvotedComment upvotedComment = UpvotedComment.builder()
                .memberId(tempMemberId)
                .commentId(commentId)
                .build();
        upvotedCommentRepository.save(upvotedComment);
    }

    public void cancelUpvoteComment(Long commentId) {
        UpvotedComment upvotedComment = UpvotedComment.builder()
                .memberId(tempMemberId)
                .commentId(commentId)
                .build();
        upvotedCommentRepository.delete(upvotedComment);
    }



}
