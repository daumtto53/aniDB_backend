package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.comment.CommentDTO;
import com.aniDB.aniDB_backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequestMapping("")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "/article/{id}/{articleId}/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDTO> submitComment(
            @PathVariable("id") Long publicationId,
            @PathVariable Long articleId,
            @RequestBody CommentDTO commentDTO
    ) {
        commentService.createComment(articleId, commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER') && @commentService.isAuthor(#commentId, authentication)")
    @PutMapping(value = "/article/{id}/{articleId}/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CommentDTO> modifyComment(
            @PathVariable("id") Long publicationId,
            @PathVariable Long articleId,
            @PathVariable Long commentId,
            @RequestBody CommentDTO commentDTO
    ) {
        CommentDTO result = commentService.updateComment(commentId, articleId, commentDTO);
        return ResponseEntity.ok(commentDTO);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER') && @commentService.isAuthor(#commentId, authentication)")
    @DeleteMapping(value = "/article/{id}/{articleId}/comment/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable Long commentId
    ) {
        commentService.deleteCommentByCommentId(commentId);
        return ResponseEntity.ok("delete");
    }

}
