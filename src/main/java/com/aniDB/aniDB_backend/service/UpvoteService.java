package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.entity.UpvotedPublication;
import com.aniDB.aniDB_backend.repository.UpvotedArticleRepository;
import com.aniDB.aniDB_backend.repository.UpvotedCommentRepository;
import com.aniDB.aniDB_backend.repository.UpvotedPublicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UpvoteService {

    private final UpvotedCommentRepository upvotedCommentRepository;
    private final UpvotedArticleRepository upvotedArticleRepository;
    private final UpvotedPublicationRepository upvotedPublicationRepository;

    //TEMPORARY ID
    private Long tempMemberId = 60L;

    public void upvotePublication(Long publicationId) {
        UpvotedPublication upvotedPublication = UpvotedPublication.builder()
                .memberId(tempMemberId)
                .publicationId(publicationId)
                .build();
        upvotedPublicationRepository.save(upvotedPublication);
    }

    public void cancelUpvotePublication(Long publicationId) {
        UpvotedPublication upvotedPublication = UpvotedPublication.builder()
                .memberId(tempMemberId)
                .publicationId(publicationId)
                .build();
        upvotedPublicationRepository.delete(upvotedPublication);
    }

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
