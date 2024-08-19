package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.entity.UpvotedPublication;
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
class UpvotedPublicationMapperTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    UpvotedPublicationMapper upvotedPublicationMapper;

    Member member;
    Publication publication;
    UpvotedPublication upvotedPublication;

    @BeforeEach
    public void setup() {
        member = Member.builder()
                .loginId("test")
                .password("test")
                .username("test")
                .build();
        memberRepository.saveNecessary(member);
        publication = Publication.builder()
                .title("test")
                .seriesType(1)
                .build();
        publicationRepository.saveNecessary(publication);
        upvotedPublication = UpvotedPublication.builder()
                .publicationId(publication.getPublicationId())
                .memberId(member.getMemberId())
                        .build();
        int cnt = upvotedPublicationMapper.insertUpvotedPublication(upvotedPublication);
    }

    @Test
    void selectUpvotedPublicationByMemberId() {
        List<UpvotedPublication> upvotedPublications = upvotedPublicationMapper.selectUpvotedPublicationByMemberId(member.getMemberId());
        Assertions.assertThat(upvotedPublications.get(0).getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(upvotedPublications.get(0).getPublicationId()).isEqualTo(publication.getPublicationId());
        Assertions.assertThat(upvotedPublications.size()).isEqualTo(1);
    }

    @Test
    void selectUpvotedPublicationByPublicationId() {
        List<UpvotedPublication> test = upvotedPublicationMapper.selectUpvotedPublicationByPublicationId(publication.getPublicationId());
        Assertions.assertThat(test.get(0).getPublicationId()).isEqualTo(publication.getPublicationId());
    }

    @Test
    void insertUpvotedPublication() {
    }

    @Test
    void updateUpvotedPublication() {
    }

    @Test
    void deleteUpvotedPublication() {
        int cnt = upvotedPublicationMapper.deleteUpvotedPublication(upvotedPublication.getMemberId(), upvotedPublication.getPublicationId());
        Assertions.assertThat(cnt).isEqualTo(1);
        cnt = upvotedPublicationMapper.deleteUpvotedPublication(upvotedPublication.getMemberId(), upvotedPublication.getPublicationId());
        Assertions.assertThat(cnt).isEqualTo(0);


    }

}