package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.SeriesComment;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.SeriesCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class SeriesCommentService {
    private final SeriesCommentRepository seriesCommentRepository;
    private final MemberRepository memberRepository;
    public SeriesComment insertSeriesComment(Long publicationId, SeriesComment seriesComment) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberRepository.findByUsername(username);

        seriesComment.setMemberId(member.getMemberId());
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
