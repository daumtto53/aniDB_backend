package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.service.UpvoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("upvote/")
public class UpvoteController {

    private final UpvoteService upvoteService;

    @GetMapping("/publication/{publicationId}")
    public ResponseEntity<Boolean> isPublicationUpvoted(
            @PathVariable Long publicationId
    ) {
        Boolean publicationUpvoted = upvoteService.isPublicationUpvoted(publicationId);
        return ResponseEntity.ok(publicationUpvoted);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/publication/{publicationId}")
    public ResponseEntity upvotePublication(
            @PathVariable Long publicationId
    ) {
        upvoteService.upvotePublication(publicationId);
        return ResponseEntity.ok("upvoted");
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/publication/{publicationId}")
    public ResponseEntity deletePublication(
            @PathVariable Long publicationId
    ) {
        upvoteService.cancelUpvotePublication(publicationId);
        return ResponseEntity.ok("canceled");
    }


    @GetMapping("/article/{articleId}")
    public ResponseEntity<Boolean> isArticleUpvoted(
            @PathVariable Long articleId
    ) {
        Boolean articleUpvoted = upvoteService.isArticleUpvoted(articleId);
        return ResponseEntity.ok(articleUpvoted);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/article/{articleId}")
    public ResponseEntity upvoteArticle(
            @PathVariable Long articleId
    ) {
        upvoteService.upvoteArticle(articleId);
        return ResponseEntity.ok("upvoted");
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/article/{articleId}")
    public ResponseEntity deleteArticle(
            @PathVariable Long articleId
    ) {
        upvoteService.cancelUpvoteArticle(articleId);
        return ResponseEntity.ok("canceled");
    }

    @GetMapping("/comment/{commentId}")
    public ResponseEntity<Boolean> isCommentUpvoted(
            @PathVariable Long commentId
    ) {
        Boolean commentUpvoted = upvoteService.isCommentUpvoted(commentId);
        return ResponseEntity.ok(commentUpvoted);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/comment/{commentId}")
    public ResponseEntity upvoteComment(
            @PathVariable Long commentId
    ) {
        upvoteService.upvoteComment(commentId);
        return ResponseEntity.ok("upvoted");
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable Long commentId
    ) {
        upvoteService.cancelUpvoteComment(commentId);
        return ResponseEntity.ok("canceled");
    }


//    @GetMapping("/comment/{commentId}")
//    public ResponseEntity<Boolean> isSeriesCommentUpvoted(
//            @PathVariable Long commentId
//    ) {
//        Boolean commentUpvoted = upvoteService.isSeriesCommentUpvoted(commentId);
//        return ResponseEntity.ok(commentUpvoted);
//    }
//
//    @PostMapping("/comment/{commentId}")
//    public ResponseEntity upvoteSeriesComment(
//            @PathVariable Long commentId
//    ) {
//        upvoteService.isSeriesCommentUpvoted(commentId);
//        return ResponseEntity.ok("upvoted");
//    }
//
//    @DeleteMapping("/comment/{commentId}")
//    public ResponseEntity deleteSeriesComment(
//            @PathVariable Long commentId
//    ) {
//        upvoteService.cancelSeriesUpvoteComment(commentId);
//        return ResponseEntity.ok("canceled");
//    }

}
