package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
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
public class UpvoteController {

    @PostMapping("/publication/{publicationId}")
    public ResponseEntity upvotePublication(
            @PathVariable Long publicationId
    ) {
        upvoteService.upvotePublication(publicationId);
        return ResponseEntity.ok("upvoted");
    }

    @DeleteMapping("/publication/{publicationId}")
    public ResponseEntity deletePublication(
            @PathVariable Long publicationId
    ) {
        upvoteService.cancelUpvotePublication(publicationId);
        return ResponseEntity.ok("canceled");
    }



    private final UpvoteService upvoteService;

    @PostMapping("/article/{articleId}")
    public ResponseEntity upvoteArticle(
            @PathVariable Long articleId
    ) {
        upvoteService.upvoteArticle(articleId);
        return ResponseEntity.ok("upvoted");
    }

    @DeleteMapping("/article/{articleId}")
    public ResponseEntity deleteArticle(
            @PathVariable Long articleId
    ) {
        upvoteService.cancelUpvoteArticle(articleId);
        return ResponseEntity.ok("canceled");
    }

    @PostMapping("/comment/{commentId}")
    public ResponseEntity upvoteComment(
            @PathVariable Long commentId
    ) {
        upvoteService.upvoteComment(commentId);
        return ResponseEntity.ok("upvoted");
    }

    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable Long commentId
    ) {
        upvoteService.cancelUpvoteComment(commentId);
        return ResponseEntity.ok("canceled");
    }


}
