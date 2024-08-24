package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final ArticleMapper articleMapper;

    public Article findById(Long articleId) {
        return articleMapper.selectArticleById(articleId);
    }

    public List<Article> findAll() {
        return articleMapper.selectAllArticles();
    }

    public void save(Article article, Long memberId) {
        articleMapper.insertArticle(article, memberId);
    }

    public void update(Article article) {
        articleMapper.updateArticle(article);
    }

    public void deleteById(Long articleId) {
        articleMapper.deleteArticleById(articleId);
    }
}