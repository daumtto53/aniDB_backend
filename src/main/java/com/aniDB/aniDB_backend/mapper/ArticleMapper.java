package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    Article selectArticleById(Long articleId);

    List<Article> selectArticlesByMemberId(Long memberId);

    List<Article> selectArticlesByPublicationId(Long publicationId);

    List<Article> selectArticlesByPublicationName(@Param("title") String publicationTitle);

    List<Article> selectAllArticles();

    int insertArticle(Article article);

    int insertArticleNecessary(Article article);

    int updateArticle(Article article);

    int deleteArticleById(Long articleId);
}