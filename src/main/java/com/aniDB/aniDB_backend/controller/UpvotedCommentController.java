package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.service.UpvotedCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("upvote/")
public class UpvotedCommentController {

    private final UpvotedCommentService upvotedCommentService;

    @PostMapping("/comment/{commentId}")
    public ResponseEntity upvoteComment(
            @PathVariable Long commentId
    ) {
        upvotedCommentService.upvoteComment(commentId);
        return ResponseEntity.ok("upvoted");
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable Long commentId
    ) {
        upvotedCommentService.cancelUpvoteComment(commentId);
        return ResponseEntity.ok("canceled");
    }

}
