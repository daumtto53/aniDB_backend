package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.entity.Comment;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.repository.ArticleRepository;
import com.aniDB.aniDB_backend.repository.MemberRepository;
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
class CommentMapperTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ArticleRepository articleRepository;

    Member member;
    Comment comment;
    Article article;

    @BeforeEach
    public void setup() {
        member = Member.builder()
                .username("test")
                .password("test")
                .loginId("test")
                .build();
        memberRepository.save(member);
        article = Article.builder()
                .title("test")
                .content("test")
                .publicationId(1L)
                .memberId(member.getMemberId())
                .build();
        articleRepository.save(article, member.getMemberId());
        comment = Comment.builder()
                .content("test")
                .memberId(member.getMemberId())
                .articleId(article.getArticleId())
                .build();
        commentMapper.insertComment(comment);
    }


    @Test
    void selectCommentById() {
        Comment test = commentMapper.selectCommentById(comment.getCommentId());
        Assertions.assertThat(test.getCommentId()).isEqualTo(comment.getCommentId());
        System.out.println(test);
    }

    @Test
    void selectAllCommentsByArticleId() {
        List<Comment> test = commentMapper.selectAllCommentsByArticleId(comment.getArticleId());
        Assertions.assertThat(test.get(0).getContent()).isEqualTo(comment.getContent());

    }

    @Test
    void insertComment() {
    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteCommentById() {
        int cnt = commentMapper.deleteCommentById(comment.getCommentId());
        Assertions.assertThat(cnt).isEqualTo(1);
    }
}