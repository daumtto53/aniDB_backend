package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AlternativePublisherName;
import com.aniDB.aniDB_backend.entity.Publisher;
import com.aniDB.aniDB_backend.repository.PublisherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test_local")

class AlternativePublisherNameMapperTest {

    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    AlternativePublisherNameMapper alternativePublisherNameMapper;

    Publisher publisher;
    AlternativePublisherName alternativePublisherName;

    @BeforeEach
    public void setup() {
        publisher = Publisher.builder().publisherName("test").build();
        publisherRepository.create(publisher);
        alternativePublisherName = AlternativePublisherName.builder()
                .originalPublisherId(publisher.getPublisherId())
                .alternativeName("Alternative Name")
                .build();
        alternativePublisherNameMapper.insert(alternativePublisherName);
    }

    @Test
    void getById() {
        AlternativePublisherName test = alternativePublisherNameMapper.getByAlternativePublisherId(alternativePublisherName.getAlternativePublisherId());
        Assertions.assertThat(test).isNotNull();
        Assertions.assertThat(test.getAlternativeName()).isEqualTo("Alternative Name");
    }

    @Test
    void getByOriginalPublisherId() {
        List<AlternativePublisherName> testList = alternativePublisherNameMapper.getByOriginalPublisherId(publisher.getPublisherId());
        Assertions.assertThat(testList).isNotEmpty();
        Assertions.assertThat(testList.size()).isEqualTo(1);
        Assertions.assertThat(testList.get(0).getOriginalPublisherId()).isEqualTo(publisher.getPublisherId());
    }

    @Test
    void insert() {
        AlternativePublisherName newAlternativeName = AlternativePublisherName.builder()
                .originalPublisherId(publisher.getPublisherId())
                .alternativeName("Another Alternative Name")
                .build();
        int result = alternativePublisherNameMapper.insert(newAlternativeName);
        Assertions.assertThat(result).isEqualTo(1);

        AlternativePublisherName inserted = alternativePublisherNameMapper.getByAlternativePublisherId(newAlternativeName.getAlternativePublisherId());
        System.out.println(inserted);
        Assertions.assertThat(inserted).isNotNull();
        Assertions.assertThat(inserted.getAlternativeName()).isEqualTo("Another Alternative Name");
    }

    @Test
    void update() {
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void delete() {
        int result = alternativePublisherNameMapper.delete(alternativePublisherName.getAlternativePublisherId());
        Assertions.assertThat(result).isEqualTo(1);

        AlternativePublisherName deleted = alternativePublisherNameMapper.getByAlternativePublisherId(alternativePublisherName.getAlternativePublisherId());
        Assertions.assertThat(deleted).isNull();
    }
}