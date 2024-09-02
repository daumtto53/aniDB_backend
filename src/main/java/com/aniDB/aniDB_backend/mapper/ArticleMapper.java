package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    Article selectArticleById(Long articleId);

    List<Article> selectArticlesByMemberId(Long memberId);

    List<Article> selectArticlesByPublicationId(Long publicationId);

    List<Article> selectArticlesByPublicationName(@Param("title") String publicationTitle);

    List<Article> selectAllArticles();

    @Update("UPDATE  anidb_article SET views = views + 1 WHERE article_id = #{articleId}")
    void incrementViews(Long articleId);

    int countAll();
    int countAllByPublicationId(Long publicationId);


    /**
     * ArticleDTO : Article 세부 페이지 반환용.
     * @param articleId
     * @return
     */
    ArticleDTO getArticleDTOById(Long articleId);



    int insertArticle(Article article, Long memberId);


    int insertArticleNecessary(Article article);

    int insertArticleDTO(ArticleDTO articleDTO);

    int updateArticle(Article article);

    int updateArticleDTO(ArticleDTO articleDTO);

    int deleteArticleById(Long articleId);

    /**
     * Article 페이징 반환용.
     * @param pageable
     * @return
     */
    List<ArticleDTO> getPages(Pageable pageable, Long publicationId);
}