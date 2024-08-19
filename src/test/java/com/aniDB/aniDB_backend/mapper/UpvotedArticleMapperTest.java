package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.*;
import com.aniDB.aniDB_backend.repository.ArticleRepository;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
class UpvotedArticleMapperTest {

    @Autowired
    UpvotedArticleMapper upvotedArticleMapper;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ArticleRepository articleRepository;

    Member member;
    Article article;
    UpvotedArticle upvotedArticle;


    @BeforeEach
    public void setup() {
        member = Member.builder()
                .loginId("test")
                .password("test")
                .username("test")
                .build();
        memberRepository.saveNecessary(member);
        article = Article.builder()
                .memberId(member.getMemberId())
                .title("test")
                .content("test")
                .build();
        articleRepository.save(article);
        upvotedArticle = UpvotedArticle.builder()
                .articleId(article.getArticleId())
                .memberId(member.getMemberId())
                .build();
        int cnt = upvotedArticleMapper.insertUpvotedArticle(upvotedArticle);
    }

    @Test
    void selectUpvotedArticleById() {
        UpvotedArticle test = upvotedArticleMapper.selectUpvotedArticleById(member.getMemberId(), article.getArticleId());
        Assertions.assertThat(test.getArticleId()).isEqualTo(article.getArticleId());
        Assertions.assertThat(test.getMemberId()).isEqualTo(article.getMemberId());
    }

    @Test
    void insertUpvotedArticle() {
    }

    @Test
    void deleteUpvotedArticle() {
        int cnt = upvotedArticleMapper.deleteUpvotedArticle(upvotedArticle.getMemberId(), upvotedArticle.getArticleId());
        Assertions.assertThat(cnt).isEqualTo(1);

    }
}