package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.RelatedSeries;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.entity.RelatedSeries;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")
class RelatedSeriesMapperTest {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    RelatedSeriesMapper relatedSeriesMapper;

    Publication publication;
    RelatedSeries relatedSeries;

    @BeforeEach
    public void setup() {
        publication = Publication.builder().title("test").seriesType(1).build();
        publicationRepository.saveNecessary(publication);
        relatedSeries = RelatedSeries.builder().publicationId(publication.getPublicationId())
                .build();
        relatedSeriesMapper.insertRelatedSeries(relatedSeries);
    }

    @Test
    void getRelatedSeriesById() {
        RelatedSeries test = relatedSeriesMapper.getRelatedSeriesById(relatedSeries.getRelatedPublicationId(), relatedSeries.getPublicationId());
        System.out.println(test);
        Assertions.assertThat(test.getRelatedPublicationId()).isEqualTo(relatedSeries.getRelatedPublicationId());
    }

    @Test
    void getRelatedSeriesByPublicationId() {
        List<RelatedSeries> testList = relatedSeriesMapper.getRelatedSeriesByPublicationId(publication.getPublicationId());
        Assertions.assertThat(testList.size()).isEqualTo(1);
    }

    @Test
    void insertRelatedSeries() {
    }

    @Test
    void updateRelatedSeries() {
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void deleteRelatedSeries() {
        int cnt = relatedSeriesMapper.deleteRelatedSeries(relatedSeries.getRelatedPublicationId(), publication.getPublicationId());
        Assertions.assertThat(cnt).isEqualTo(1);
        RelatedSeries empty = relatedSeriesMapper.getRelatedSeriesById(relatedSeries.getRelatedPublicationId(), publication.getPublicationId());
        Assertions.assertThat(empty).isEqualTo(null);
    }
}