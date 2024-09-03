package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.entity.UpvotedPublication;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.UpvotedArticleRepository;
import com.aniDB.aniDB_backend.repository.UpvotedCommentRepository;
import com.aniDB.aniDB_backend.repository.UpvotedPublicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UpvoteService {

    private final UpvotedCommentRepository upvotedCommentRepository;
    private final UpvotedArticleRepository upvotedArticleRepository;
    private final UpvotedPublicationRepository upvotedPublicationRepository;
    private final MemberRepository memberRepository;

    //TEMPORARY ID

    public Boolean isPublicationUpvoted(Long publicationId) {
        UpvotedPublication upvotedPublication = upvotedPublicationRepository.find(getMemberIdFromAuth(), publicationId);
        if (upvotedPublication == null)
            return false;
        else
            return true;
    }

    public void upvotePublication(Long publicationId) {
        UpvotedPublication upvotedPublication = UpvotedPublication.builder()
                .memberId(getMemberIdFromAuth())
                .publicationId(publicationId)
                .build();
        upvotedPublicationRepository.save(upvotedPublication);
    }

    public void cancelUpvotePublication(Long publicationId) {

        UpvotedPublication upvotedPublication = UpvotedPublication.builder()
                .memberId(getMemberIdFromAuth())
                .publicationId(publicationId)
                .build();
        upvotedPublicationRepository.delete(upvotedPublication);
    }

    public Boolean isArticleUpvoted(Long articleId) {
        UpvotedArticle upvotedArticle = upvotedArticleRepository.find(getMemberIdFromAuth(), articleId);
        if (upvotedArticle == null)
            return false;
        else
            return true;
    }

    public void upvoteArticle(Long articleId) {

        UpvotedArticle upvotedArticle = UpvotedArticle.builder()
                .memberId(getMemberIdFromAuth())
                .articleId(articleId)
                .build();
        upvotedArticleRepository.save(upvotedArticle);
    }

    public void cancelUpvoteArticle(Long articleId) {
        UpvotedArticle upvotedArticle = UpvotedArticle.builder()
                .memberId(getMemberIdFromAuth())
                .articleId(articleId)
                .build();
        upvotedArticleRepository.delete(upvotedArticle);
    }

    public Boolean isCommentUpvoted(Long commentId) {
        UpvotedComment upvotedComment = upvotedCommentRepository.find(getMemberIdFromAuth(), commentId);
        if (upvotedComment == null)
            return false;
        else
            return true;
    }

    public void upvoteComment(Long commentId) {
        UpvotedComment upvotedComment = UpvotedComment.builder()
                .memberId(getMemberIdFromAuth())
                .commentId(commentId)
                .build();
        upvotedCommentRepository.save(upvotedComment);
    }

    public void cancelUpvoteComment(Long commentId) {
        UpvotedComment upvotedComment = UpvotedComment.builder()
                .memberId(getMemberIdFromAuth())
                .commentId(commentId)
                .build();
        upvotedCommentRepository.delete(upvotedComment);
    }

    public Long getMemberIdFromAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberRepository.findByUsername(username);
        return member.getMemberId();
    }


}
