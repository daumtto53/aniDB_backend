package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.repository.UpvotedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class UpvotedCommentService {

    private final UpvotedCommentRepository upvotedCommentRepository;
    //TEMPORARY ID
    private Long tempMemberId = 60L;

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
