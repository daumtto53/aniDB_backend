package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Genre;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.entity.PublicationGenre;
import com.aniDB.aniDB_backend.repository.GenreRepository;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
class PublicationGenreMapperTest {
    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    PublicationGenreMapper publicationGenreMapper;

    Publication publication;
    Genre genre;
    PublicationGenre publicationGenre;

    @BeforeEach
    public void setup() {
        publication = Publication.builder()
                .title("test")
                .seriesType(1)
                .build();
        genre = Genre.builder()
                .genreName("test")
                .build();
        publicationRepository.saveNecessary(publication);
        genreRepository.create(genre);
        publicationGenre = PublicationGenre.builder()
                .publicationId(publication.getPublicationId())
                .genreId(genre.getGenreId())
                .build();
        publicationGenreMapper.insert(publicationGenre);
    }

    @Test
    void getByIds() {
        PublicationGenre test = publicationGenreMapper.getByPublicationIdAndGenreId(publication.getPublicationId(), genre.getGenreId());
        Assertions.assertThat(test.getPublicationId()).isEqualTo(publication.getPublicationId());
        Assertions.assertThat(test.getGenreId()).isEqualTo(genre.getGenreId());

    }

    @Test
    void getByTitleId() {
        List<PublicationGenre> pg = publicationGenreMapper.getByPublicationId(publication.getPublicationId());
        Assertions.assertThat(pg.size()).isEqualTo(1);
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
        int count = publicationGenreMapper.delete(publicationGenre.getPublicationId(), publicationGenre.getGenreId());
        Assertions.assertThat(count).isEqualTo(1);
    }
}