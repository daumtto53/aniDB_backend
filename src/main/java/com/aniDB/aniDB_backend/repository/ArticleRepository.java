package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.mapper.ArticleMapper;
import com.aniDB.aniDB_backend.mapper.UpvotedArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final ArticleMapper articleMapper;
    private final UpvotedArticleMapper upvotedArticleMapper;

    public Article findById(Long articleId) {
        return articleMapper.selectArticleById(articleId);
    }



    public List<Article> findAll() {
        return articleMapper.selectAllArticles();
    }

    public ArticleDTO getArticleDTOById(Long articleId) {
        return articleMapper.getArticleDTOById(articleId);
    }


    public void save(Article article, Long memberId) {
        articleMapper.insertArticle(article, memberId);
    }

    public void update(Article article) {
        articleMapper.updateArticle(article);
    }

    public void deleteById(Long articleId) {
        upvotedArticleMapper.deleteUpvotedArticleById(articleId);
        articleMapper.deleteArticleById(articleId);
    }

    public List<ArticleDTO> getPages(Pageable pageable, Long publicationId) {
        return articleMapper.getPages(pageable, publicationId);
    }


    public int countAll() {
        return articleMapper.countAll();
    }

    public int countAllByPublicationId(Long publicationId) {
        return articleMapper.countAllByPublicationId(publicationId);
    }

    public int createArticle(ArticleDTO articleDTO) {
        return articleMapper.insertArticleDTO(articleDTO);
    }

    public int modifyArticle(ArticleDTO articleDTO) {
        return articleMapper.updateArticleDTO(articleDTO);
    }

}