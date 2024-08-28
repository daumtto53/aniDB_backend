package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
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

import java.security.SecureRandom;
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
        AdvancedSearchDTO advancedSearchDTO = AdvancedSearchDTO.builder().build().setAdvancedSearchDTOToDefault();
        SearchDTO searchDTO = SearchDTO.builder().build();
        int count = publicationMapper.countAllPublications(searchDTO, advancedSearchDTO);

        //when
        List<Publication> publications = publicationMapper.selectAllPublications();

        //then
        Assertions.assertThat(publications.size()).isEqualTo(count);
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
        AdvancedSearchDTO advancedSearchDTO = AdvancedSearchDTO.builder().build().setAdvancedSearchDTOToDefault();
        SearchDTO searchDTO = SearchDTO.builder().build();
        Pageable pageable = new PageRequestDTO(1).getPageable();
        List<PublicationPageDTO> page = publicationMapper.getPage(pageable,searchDTO, advancedSearchDTO);
        System.out.println(page.size());
        System.out.println(page);
    }
}