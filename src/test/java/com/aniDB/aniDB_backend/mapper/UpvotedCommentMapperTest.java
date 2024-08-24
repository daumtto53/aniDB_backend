package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.entity.Comment;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.entity.UpvotedComment;
import com.aniDB.aniDB_backend.repository.ArticleRepository;
import com.aniDB.aniDB_backend.repository.CommentRepository;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
@ActiveProfiles("test_local")
class UpvotedCommentMapperTest {

    @Autowired
    UpvotedCommentMapper upvotedCommentMapper;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;

    UpvotedComment upvotedComment;
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
                .memberId(member.getMemberId())
                .articleId(article.getArticleId())
                .content("test")
                .build();
        commentRepository.save(comment);
        upvotedComment = UpvotedComment.builder()
                .memberId(member.getMemberId())
                .commentId(comment.getCommentId())
                .build();
        upvotedCommentMapper.insertUpvotedComment(upvotedComment);
    }

    @Test
    void selectUpvotedCommentById() {
        UpvotedComment test = upvotedCommentMapper.selectUpvotedCommentById(member.getMemberId(), comment.getCommentId());
        Assertions.assertThat(test.getCommentId()).isEqualTo(comment.getCommentId());
    }

    @Test
    void insertUpvotedComment() {
    }

    @Test
    void deleteUpvotedComment() {
        int cnt = upvotedCommentMapper.deleteUpvotedComment(upvotedComment.getMemberId(), upvotedComment.getCommentId());
        Assertions.assertThat(cnt).isEqualTo(1);
    }
}