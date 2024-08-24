package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.entity.SeriesComment;
import com.aniDB.aniDB_backend.repository.SeriesCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SeriesCommentService {
    private final SeriesCommentRepository seriesCommentRepository;

    public SeriesComment insertSeriesComment(Long publicationId, SeriesComment seriesComment) {
        seriesComment.setPublicationId(publicationId);
        int cnt = seriesCommentRepository.insertSeriesComment(seriesComment);
        log.info("Inserted SeriesComment: {}, effected={}", seriesComment, cnt);
        return seriesComment;
    }

    public SeriesComment updateSeriesComment(Long publicationId, Long seriesCommentId, SeriesComment seriesComment) {
        seriesComment.setSeriesCommentId(seriesCommentId);
        seriesComment.setPublicationId(publicationId);
        int cnt = seriesCommentRepository.updateSeriesComment(seriesComment);
        log.info("Updated SeriesComment: {}, effected={}", seriesComment, cnt);
        return seriesComment;
    }


    public void deleteSeriesComment(Long seriesCommentId) {
        seriesCommentRepository.deleteSeriesComment(seriesCommentId);
    }
}
