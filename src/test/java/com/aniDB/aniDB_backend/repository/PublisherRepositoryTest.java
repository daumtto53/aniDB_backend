package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")
class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    void getPage() {
        AdvancedSearchDTO advancedSearchDTO = AdvancedSearchDTO.builder().build();
        SearchDTO searchDTO = SearchDTO.builder().build();
        Pageable pageable = new PageRequestDTO(1).getPageable();
        List<PublisherPageDTO> page = publisherRepository.getPage(pageable, searchDTO, advancedSearchDTO);
        System.out.println(page);
    }

    @Test
    void getPublisherDTOById() {
        PublisherDTO publisherDTOById = publisherRepository.getPublisherDTOById(1451L);
        System.out.println(publisherDTOById.getPublisherName());
        System.out.println(publisherDTOById.getParentPublisherId());
        System.out.println(publisherDTOById.getParentPublisherName());
        System.out.println(publisherDTOById.getAlternativePublisherNameList());
        System.out.println(publisherDTOById.getLabelList());
        System.out.println(publisherDTOById.getDescendantPublicationList());
        System.out.println(publisherDTOById.getDescendantPublicationCount());
    }

    @Test
    void countAll() {
        System.out.println(publisherRepository.countAll());
    }
}