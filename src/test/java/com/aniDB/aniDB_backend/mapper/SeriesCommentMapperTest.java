package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.entity.SeriesComment;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
class SeriesCommentMapperTest {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    SeriesCommentMapper seriesCommentMapper;

    Publication publication;
    Member member;
    SeriesComment seriesComment;

    @BeforeEach
    public void setup() {
        member = Member.builder()
                .username("ttest")
                .password("ttest")
                .loginId("ttest")
                .build();
        memberRepository.saveNecessary(member);
        publication = Publication.builder()
                .title("test")
                .seriesType(1)
                .build();
        publicationRepository.saveNecessary(publication);
        seriesComment = SeriesComment.builder()
                .anidbComment("comment")
                .memberId(member.getMemberId())
                .publicationId(publication.getPublicationId())
                .build();
        seriesCommentMapper.insertSeriesComment(seriesComment);
    }


    @Test
    void insertSeriesComment() {
        //TODO
    }

    @Test
    void selectSeriesCommentsByPublicationId() {
        List<SeriesComment> seriesComments = seriesCommentMapper.selectSeriesCommentsByPublicationId(publication.getPublicationId());
        System.out.println(seriesComments);
        Assertions.assertThat(seriesComments.size()).isEqualTo(1);
        Assertions.assertThat(seriesComments.get(0).getAnidbComment()).isEqualTo("comment");
    }

    @Test
    void updateSeriesComment() {
        //given
        SeriesComment toChange = seriesCommentMapper.findById(seriesComment.getSeriesCommentId());
        Assertions.assertThat(toChange.getAnidbComment()).isEqualTo("comment");
        //when
        toChange.setAnidbComment("comment2");
        seriesCommentMapper.updateSeriesComment(toChange);
        //then
        SeriesComment result = seriesCommentMapper.findById(seriesComment.getSeriesCommentId());
        Assertions.assertThat(result.getAnidbComment()).isEqualTo("comment2");

    }

    @Test
    void deleteSeriesComment() {
        int cnt = seriesCommentMapper.deleteSeriesComment(seriesComment.getSeriesCommentId());
        Assertions.assertThat(cnt).isEqualTo(1);
    }
}