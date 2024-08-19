package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.entity.PublicationPublisher;
import com.aniDB.aniDB_backend.entity.Publisher;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import com.aniDB.aniDB_backend.repository.PublisherRepository;
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
class PublicationPublisherMapperTest {

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    PublisherRepository publisherRepository;
    @Autowired
    PublicationPublisherMapper publicationPublisherMapper;

    Publication publication;
    Publisher publisher;
    PublicationPublisher test;

    @BeforeEach
    public void setup() {
        publication = Publication.builder()
                .title("test")
                .seriesType(1)
                .build();
        publisher = Publisher.builder()
                .publisherName("test")
                .build();
        publicationRepository.saveNecessary(publication);
        publisherRepository.create(publisher);
        test = PublicationPublisher.builder()
                .publicationId(publication.getPublicationId())
                .publisherId(publisher.getPublisherId())
                .build();
        int insert = publicationPublisherMapper.insert(test);
    }
    @Test
    void getByIds() {
        PublicationPublisher retrieved = publicationPublisherMapper.getByIds(test.getPublicationId(), test.getPublisherId());
        Assertions.assertThat(retrieved.getPublicationId()).isEqualTo(test.getPublicationId());
        Assertions.assertThat(retrieved.getPublisherId()).isEqualTo(test.getPublisherId());
        System.out.println(retrieved);
        System.out.println(test);
    }

    @Test
    void getByPublicationId() {
        List<PublicationPublisher> retrieved = publicationPublisherMapper.getByPublicationId(this.test.getPublicationId());
        Assertions.assertThat(retrieved.size()).isEqualTo(1);
    }

    @Test
    void insert() {
        //
    }

    @Test
    void delete() {
        int delete = publicationPublisherMapper.delete(test.getPublicationId(), test.getPublisherId());
        Assertions.assertThat(delete).isEqualTo(1);
    }
}