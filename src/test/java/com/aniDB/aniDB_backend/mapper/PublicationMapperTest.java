package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.entity.Publication;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")
class PublicationMapperTest {

    @Autowired
    PublicationMapper publicationMapper;

    Publication publication;

    @BeforeEach
    public void setup() {
        publication = Publication.builder()
                .title("test")
                .seriesType(1)
                .build();
        publicationMapper.insertPublicationNecessary(publication);
    }

    @Test
    void selectPublicationById() {
        //given

        //when
        Publication retrieved = publicationMapper.selectPublicationById(publication.getPublicationId());

        //then
        Assertions.assertThat(retrieved.getPublicationId()).isEqualTo(publication.getPublicationId());

    }

    @Test
    void selectPublicationByTitle() {
        //given

        //when
        List<Publication> testList = publicationMapper.selectPublicationByTitle("test");

        //then
        Assertions.assertThat(testList.size()).isEqualTo(1);
        Assertions.assertThat(testList.get(0).getPublicationId()).isEqualTo(publication.getPublicationId());
        Assertions.assertThat(testList.get(0).getTitle()).isEqualTo(publication.getTitle());
    }

    @Test
    void selectPublicationByTitleAndSeriesType() {
        ///given

        //when
        Publication test = publicationMapper.selectPublicationByTitleAndSeriesType(publication.getTitle(), "Manga");

        //then
        Assertions.assertThat(test.getTitle()).isEqualTo(publication.getTitle());
        Assertions.assertThat(test.getSeriesType()).isEqualTo(publication.getSeriesType());
        System.out.println(test);
    }

    @Test
    void selectAllPublications() {
        //given
        int count = publicationMapper.countAllPublications();

        //when
        List<Publication> publications = publicationMapper.selectAllPublications();

        //then
        Assertions.assertThat(publications.size()).isEqualTo(count);
    }

    @Test
    void insertPublication() {
        //TODO
    }

    @Test
    void insertPublicationNecessary() {
        Publication test1 = Publication.builder()
                .title("test1")
                .seriesType(1)
                .build();
        publicationMapper.insertPublicationNecessary(test1);
        Publication publication1 = publicationMapper.selectPublicationById(test1.getPublicationId());
        Assertions.assertThat(publication1.getTitle()).isEqualTo(test1.getTitle());
    }

    @Test
    void updatePublication() {
        //TODO
    }

    @Test
    void deletePublication() {
        int cnt = publicationMapper.deletePublication(publication.getPublicationId());
        Assertions.assertThat(cnt).isEqualTo(1);
    }

    @Test
    void getPage() {
        Pageable pageable = new PageRequestDTO(1).getPageable();
        List<Publication> page = publicationMapper.getPage(pageable);
        int cnt = publicationMapper.countAllPublications();
        System.out.println(page.size());
        System.out.println(page);
        System.out.println(cnt);
    }


    @Test
    void getPublicationDTOById() {
        PublicationDTO dto = publicationMapper.getPublicationDTOById(1L);
        System.out.println(dto);
    }

    @Test
    void selectPublicationWithComments() {
        List<Publication> publications = publicationMapper.selectPublicationWithComments(1L);
        System.out.println(publications);
    }
}