package com.aniDB.aniDB_backend.controller;


import com.aniDB.aniDB_backend.entity.SeriesComment;
import com.aniDB.aniDB_backend.repository.SeriesCommentRepository;
import com.aniDB.aniDB_backend.service.SeriesCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/info")
public class SeriesCommentController {
    private final SeriesCommentService seriesCommentService;

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/publication/{id}/comment")
    public ResponseEntity<SeriesComment> submitSeriesComment (
            @PathVariable("id") Long publicationId,
            @RequestBody SeriesComment seriesComment
    ) {
        SeriesComment insertedSeriesComment = seriesCommentService.insertSeriesComment(publicationId, seriesComment);
        return ResponseEntity.status(201).body(insertedSeriesComment);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER') && @seriesCommentService.isAuthor(#commentId, authentication)")
    @PutMapping("/publication/{id}/comment/{commentId}")
    public ResponseEntity<SeriesComment> modifySeriesComment (
            @PathVariable("id") Long publicationId,
            @PathVariable Long commentId,
            @RequestBody SeriesComment seriesComment
    ) {
        SeriesComment updatedSeriesComment = seriesCommentService.updateSeriesComment(publicationId, commentId, seriesComment);
        return ResponseEntity.ok(updatedSeriesComment);
    }

    /**
     * Authority 필요.
     */
    @PreAuthorize("hasRole('USER') && @seriesCommentService.isAuthor(#commentId, authentication)")
    @DeleteMapping("/publication/{id}/comment/{commentId}")
    public ResponseEntity deleteSeriesComment (
            @PathVariable("id") Long publicationId,
            @PathVariable Long commentId
    ) {
        seriesCommentService.deleteSeriesComment(commentId);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }


}
