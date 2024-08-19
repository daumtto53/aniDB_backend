package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AnimeAdaptation;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test_local")
@Transactional
class AnimeAdaptationMapperTest {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    AnimeAdaptationMapper animeAdaptationMapper;

    Publication publication;
    AnimeAdaptation animeAdaptation;

    @BeforeEach
    public void setup() {
        publication = publicationRepository.findById(1L);
        animeAdaptation = AnimeAdaptation.builder()
                .animeId(null)
                .publicationId(publication.getPublicationId())
                .animeName("test")
                .build();
        animeAdaptationMapper.insert(animeAdaptation);
    }

    @Test
    void insert() {

    }

    @Test
    void selectByAnimeAdaptationId() {
        AnimeAdaptation test = animeAdaptationMapper.selectByAnimeAdaptationId(animeAdaptation.getAnimeAdaptationId());
        Assertions.assertThat(test.getAnimeAdaptationId()).isEqualTo(animeAdaptation.getAnimeAdaptationId());
        Assertions.assertThat(test.getPublicationId()).isEqualTo(animeAdaptation.getPublicationId());
        System.out.println(test);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        int cnt = animeAdaptationMapper.delete(animeAdaptation.getAnimeAdaptationId());
        Assertions.assertThat(cnt).isEqualTo(1);
        cnt = animeAdaptationMapper.delete(animeAdaptation.getAnimeAdaptationId());
        Assertions.assertThat(cnt).isEqualTo(0);
    }
}