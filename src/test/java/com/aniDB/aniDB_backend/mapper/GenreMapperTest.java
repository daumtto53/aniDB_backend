package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Genre;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
@ActiveProfiles("test_local")
class GenreMapperTest {

    @Autowired
    GenreMapper mapper;

    Genre testGenre;

    @BeforeEach
    public void setup() {
        testGenre = Genre.builder()
                .genreName("TestGenre")
                .build();
        mapper.insert(testGenre);
    }

    @Test
    @Order(1)
    void getById() {
        Genre retrieved = mapper.getById(testGenre.getGenreId());
        Assertions.assertThat(retrieved.getGenreId()).isEqualTo(testGenre.getGenreId());
        Assertions.assertThat(retrieved.getGenreName()).isEqualTo("TestGenre");
    }

    @Test
    @Order(2)
    void getAll() {
        List<Genre> genres = mapper.getAll();
        Assertions.assertThat(genres).isNotEmpty();
        Assertions.assertThat(genres.size()).isEqualTo(mapper.countAll());
    }

    @Test
    @Order(3)
    void insert() {
        Genre newGenre = Genre.builder()
                .genreName("NewTestGenre")
                .build();
        int insertCount = mapper.insert(newGenre);
        Assertions.assertThat(insertCount).isEqualTo(1);
        Assertions.assertThat(newGenre.getGenreId()).isNotNull();
    }

    @Test
    @Order(4)
    void update() {

    }

    @Test
    @Order(5)
    void delete() {
        int deleteCount = mapper.delete(testGenre.getGenreId());
        Assertions.assertThat(deleteCount).isEqualTo(1);

        Genre deletedGenre = mapper.getById(testGenre.getGenreId());
        Assertions.assertThat(deletedGenre).isNull();
    }
}