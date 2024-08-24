package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("")
public class ArticleController {

    private final ArticleService articleService;

    /**
     * Paging 정보 반환
     */
    @GetMapping(value = "/article/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO> getArticlePageDTO(
            @PathVariable("id") Long publicationId,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam("page") String page,
            @RequestParam(value = "option", required = false) String option,
            @RequestParam(value = "searchQuery", required = false) String searchQuery
    ){
        PageResultDTO<ArticleDTO, ArticleDTO> articleDTOPage = articleService.getArticleDTOPage(Integer.valueOf(page), publicationId);
        return ResponseEntity.ok(articleDTOPage);
    }


    /**
     * 세부 article 정보 반환
     */
    @GetMapping("/article/{id}/{articleId}")
    public ResponseEntity getArticleDTO(
            @PathVariable("id") Long publicationId,
            @PathVariable("articleId") Long articleId
    ){
        ArticleDTO result = articleService.getArticle(articleId);
        return ResponseEntity.ok(result);
    }

    /**
     * article 등록
     */
    @PostMapping("/article/{id}")
    public ResponseEntity saveArticle(
            @PathVariable("id") Long publicationId,
            @RequestBody ArticleDTO articleDTO
    ) {
        ArticleDTO article = articleService.createArticle(publicationId, articleDTO);
        return ResponseEntity.ok(article);
    }

    /**
     * article 수정
     */
    @PutMapping("/article/{id}/{articleId}")
    public ResponseEntity modifyArticle(
            @PathVariable("id") Long publicationId,
            @PathVariable("articleId") Long articleId,
            @RequestBody ArticleDTO articleDTO
    ) {
        ArticleDTO result = articleService.modifyArticle(articleId, articleDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/article/{id}/{articleId}")
    public ResponseEntity deleteArticle(
            @PathVariable("id") Long publicationId,
            @PathVariable("articleId") Long articleId
    ) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok("deleted");
    }



}
