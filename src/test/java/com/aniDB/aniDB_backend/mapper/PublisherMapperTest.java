package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Publisher;
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
class PublisherMapperTest {

    @Autowired
    PublisherMapper publisherMapper;

    Publisher publisher;

    @BeforeEach
    public void setup() {
        publisher = Publisher.builder()
                .publisherName("test")
                .build();
        publisherMapper.insert(publisher);
    }

    @Test
    void getById() {
        //given

        //when
        Publisher retrieved = publisherMapper.getByPublisherId(publisher.getPublisherId());

        //then
        Assertions.assertThat(retrieved.getPublisherId()).isEqualTo(publisher.getPublisherId());
    }

    @Test
    void getAll() {
        //given
        int count = publisherMapper.countAll();

        //when
        List<Publisher> publishers = publisherMapper.getAll();

        //then
        Assertions.assertThat(publishers.size()).isEqualTo(count);
    }

    @Test
    void insert() {
        //given
        Publisher newPublisher = Publisher.builder()
                .publisherName("test_insert")
                .build();
        //when
        int result = publisherMapper.insert(newPublisher);

        //then
        Assertions.assertThat(result).isEqualTo(1);
        Publisher inserted = publisherMapper.getByPublisherId(newPublisher.getPublisherId());
        Assertions.assertThat(inserted).isNotNull();
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        //when
        int result = publisherMapper.delete(publisher.getPublisherId());

        //then
        Assertions.assertThat(result).isEqualTo(1);
        Publisher deleted = publisherMapper.getByPublisherId(publisher.getPublisherId());
        Assertions.assertThat(deleted).isNull();
    }
}