package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AlternativeTitle;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
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
class AlternativeTitleMapperTest {

    @Autowired
    PublicationRepository publicationRepository;

    @Autowired
    AlternativeTitleMapper alternativeTitleMapper;
    Publication publication;
    AlternativeTitle alternativeTitle;

    @BeforeEach
    public void setup() {
        publication = Publication.builder().title("test").seriesType(1).build();
        publicationRepository.saveNecessary(publication);
        alternativeTitle = AlternativeTitle.builder().publicationId(publication.getPublicationId())
                .alternativeTitle("test")
                .build();
        alternativeTitleMapper.insertAlternativeTitle(alternativeTitle);
    }

    @Test
    void getAlternativeTitleById() {
        AlternativeTitle test = alternativeTitleMapper.getAlternativeTitleById(alternativeTitle.getAlternativeTitleId(), alternativeTitle.getPublicationId());
        System.out.println(test);
        Assertions.assertThat(test.getAlternativeTitle()).isEqualTo(alternativeTitle.getAlternativeTitle());
    }

    @Test
    void getAlternativeTitlesByPublicationId() {
        List<AlternativeTitle> testList = alternativeTitleMapper.getAlternativeTitlesByPublicationId(publication.getPublicationId());
        Assertions.assertThat(testList.size()).isEqualTo(1);
    }

    @Test
    void insertAlternativeTitle() {
        //BeforeEach에서 Test
    }

    @Test
    void updateAlternativeTitle() {

    }

    @Test
    void deleteAlternativeTitle() {
        int i = alternativeTitleMapper.deleteAlternativeTitle(alternativeTitle.getAlternativeTitleId(), publication.getPublicationId());
        Assertions.assertThat(i).isEqualTo(1);
        AlternativeTitle empty = alternativeTitleMapper.getAlternativeTitleById(alternativeTitle.getAlternativeTitleId(), publication.getPublicationId());
        Assertions.assertThat(empty).isEqualTo(null);
    }
}