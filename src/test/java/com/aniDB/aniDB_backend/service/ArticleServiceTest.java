package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void getArticleDTOPage() {
    }

    @Test
    void getArticle() {
    }

    @Test
    void createArticle() {
        Member member1 = memberRepository.findById(1L);
        ArticleDTO dto = ArticleDTO.builder().publicationId(1L)
                .memberDTO(
                        MemberDTO.builder()
                                .memberId(member1.getMemberId())
                                .build()
                )
                .title("test")
                .content("test")
                .build();
        ArticleDTO article = articleService.createArticle(1L, dto);
        Assertions.assertThat(article.getTitle()).isEqualTo("test");
        Assertions.assertThat(article.getContent()).isEqualTo("test");
        System.out.println(article);

    }
}