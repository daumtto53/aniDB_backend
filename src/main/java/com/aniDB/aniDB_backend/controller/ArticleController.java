package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
            @RequestParam(value = "page", defaultValue = "1") String page,
            @RequestParam(value = "option", required = false) String option,
            @RequestParam(value = "searchQuery", required = false) String searchQuery
    ){
        PageResultDTO<ArticleDTO, ArticleDTO> articleDTOPage = articleService.getArticleDTOPage(Integer.valueOf(page), publicationId);
        log.info("articleDTOPage = {}", articleDTOPage);
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
     * Authority 필요..
     */
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/article/{id}")
    public ResponseEntity saveArticle(
            @PathVariable("id") Long publicationId,
            @RequestBody ArticleDTO articleDTO
    ) {
        if (articleDTO.getContent().equals("") || articleDTO.getTitle().equals(""))
            return ResponseEntity.noContent().build();
        ArticleDTO article = articleService.createArticle(publicationId, articleDTO);
        return ResponseEntity.ok(article);
    }

    /**
     * article 수정
     * Authority 필요
     */
    @PreAuthorize("hasRole('USER') && @articleService.isAuthor(#articleId, authentication)")
    @PutMapping(value = "/article/{id}/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifyArticle(
            @PathVariable("id") Long publicationId,
            @PathVariable("articleId") Long articleId,
            @RequestBody ArticleDTO articleDTO
    ) {
        log.info("modifyArticle = {}", articleDTO);
        ArticleDTO result = articleService.modifyArticle(articleId, articleDTO);
        return ResponseEntity.ok(result);
    }

    /**
     * Autohrity 필요.
     */

    @PreAuthorize("hasRole('USER') && @articleService.isAuthor(#articleId, authentication)")
    @DeleteMapping("/article/{id}/{articleId}")
    public ResponseEntity deleteArticle(
            @PathVariable("id") Long publicationId,
            @PathVariable("articleId") Long articleId
    ) {
        articleService.deleteArticle(articleId);
        return ResponseEntity.ok("deleted");
    }



}
