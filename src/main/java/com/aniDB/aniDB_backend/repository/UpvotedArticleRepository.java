package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import com.aniDB.aniDB_backend.mapper.UpvotedArticleMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UpvotedArticleRepository {

    private final UpvotedArticleMapper upvotedArticleMapper;

    public UpvotedArticleRepository(UpvotedArticleMapper upvotedArticleMapper) {
        this.upvotedArticleMapper = upvotedArticleMapper;
    }

    public UpvotedArticle findById(Long articleId) {
        return upvotedArticleMapper.selectUpvotedArticleById(articleId);
    }

    public int save(UpvotedArticle upvotedArticle) {
        return  upvotedArticleMapper.insertUpvotedArticle(upvotedArticle);
    }


    public int delete(Long articleId) {
        return  upvotedArticleMapper.deleteUpvotedArticleById(articleId);
    }
}