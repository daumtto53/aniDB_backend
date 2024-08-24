package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    UpvotedArticleMapper upvotedArticleMapper;

    Article article;
    Member member;
    UpvotedArticle upvotedArticle;


    @BeforeEach
    public void setup() {
        member = Member.builder()
                .username("membertest")
                .password("membertest")
                .loginId("membertest")
                .build();
        memberRepository.save(member);
        article = Article.builder()
                .title("test")
                .content("test")
                .publicationId(1L)
                .memberId(member.getMemberId())
                .build();
        articleMapper.insertArticle(article, member.getMemberId());
        upvotedArticle = UpvotedArticle.builder()
                .articleId(article.getArticleId())
                .memberId(member.getMemberId())
                .build();
        upvotedArticleMapper.insertUpvotedArticle(upvotedArticle);
    }

    @Test
    void selectArticleById() {
        Article test = articleMapper.selectArticleById(article.getArticleId());
        Assertions.assertThat(test.getArticleId()).isEqualTo(article.getArticleId());
    }

    @Test
    void selectArticlesByMemberId() {
        List<Article> articles = articleMapper.selectArticlesByMemberId(member.getMemberId());
        Assertions.assertThat(articles.size()).isEqualTo(1);
        Assertions.assertThat(articles.get(0).getContent()).isEqualTo("test");
    }

    @Test
    void selectArticlesByPublicationId() {
        List<Article> articles = articleMapper.selectArticlesByPublicationId(1L);
        Assertions.assertThat(articles.get(0).getPublicationId()).isEqualTo(1L);
    }

    @Test
    void selectArticlesByPublicationName() {
        List<Article> articles = articleMapper.selectArticlesByPublicationName("\"Bungaku Shoujo\"");
        Assertions.assertThat(articles.get(0).getPublicationId()).isEqualTo(1);
    }

    @Test
    void selectAllArticles() {
        List<Article> articles = articleMapper.selectAllArticles();
        Assertions.assertThat(articles.size()).isEqualTo(1);
    }

    @Test
    @Order(1)
    void insertArticle() {
    }

    @Test
    void updateArticle() {
        //TODo
    }

    @Test
    @Order(Integer.MAX_VALUE)
    void deleteArticleById() {
        int cnt = articleMapper.deleteArticleById(article.getArticleId());
        Assertions.assertThat(cnt).isEqualTo(1);
    }

    @Test
    void getArticleDTO() {
        ArticleDTO articleDTO = articleMapper.getArticleDTOById(article.getArticleId());
        Assertions.assertThat(articleDTO.getMemberDTO().getMemberId()).isEqualTo(member.getMemberId());
        Assertions.assertThat(articleDTO.getArticleId()).isEqualTo(article.getArticleId());
        System.out.println(articleDTO);
    }

    @Test
    void getArticleDTO_2() {
        ArticleDTO articleDTOById = articleMapper.getArticleDTOById(1L);
        System.out.println(articleDTOById);
    }

    @Test
    void getPages() {
        Pageable pageable = new PageRequestDTO(1).getPageable();
        List<ArticleDTO> pages = articleMapper.getPages(pageable);
        System.out.println(pages);
    }
}