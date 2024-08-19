package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.UpvotedArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UpvotedArticleMapper {

    UpvotedArticle selectUpvotedArticleById(@Param("memberId") Long memberId, @Param("articleId") Long articleId);

    int insertUpvotedArticle(UpvotedArticle upvotedArticle);

    int deleteUpvotedArticle(@Param("memberId") Long memberId, @Param("articleId") Long articleId);
}