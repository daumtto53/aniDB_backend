package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
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
class ArticleRepositoryTest {
    @Autowired
    ArticleRepository articleRepository;

    @Test
    void getArticleDTOById() {
        ArticleDTO articleDTOById = articleRepository.getArticleDTOById(1L);
        System.out.println(articleDTOById);

    }

    @Test
    void getPages() {
        List<ArticleDTO> pages = articleRepository.getPages(new PageRequestDTO(1).getPageable(), 1L);
        System.out.println(pages);
    }

    @Test
    void deleteById() {
    }
}