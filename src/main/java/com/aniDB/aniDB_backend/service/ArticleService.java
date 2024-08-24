package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.repository.ArticleRepository;
import com.aniDB.aniDB_backend.repository.UpvotedArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UpvotedArticleRepository upvotedArticleRepository;

    public PageResultDTO<ArticleDTO, ArticleDTO> getArticleDTOPage(int page, Long publicationId) {
        Pageable pageable = new PageRequestDTO(page).getPageable();
        List<ArticleDTO> pages = articleRepository.getPages(pageable, publicationId);
        int totalCount = articleRepository.countAllByPublicationId(publicationId);
        Page<ArticleDTO> result = new PageImpl<>(pages, pageable, totalCount);

        Function<ArticleDTO, ArticleDTO> fn = (en -> en);
        PageResultDTO<ArticleDTO, ArticleDTO> pageResult = new PageResultDTO<>(result, fn);
        return pageResult;
    }

    public ArticleDTO getArticle(Long articleId) {
        return articleRepository.getArticleDTOById(articleId);
    }

     /* TODO Spring Context - member needed. */
    public ArticleDTO createArticle(Long publicationId, ArticleDTO articleDTO) {
        articleDTO.setPublicationId(publicationId);
        // Securtiy Context.
        articleDTO.setMemberDTO(MemberDTO.builder().memberId(1L).build());
        int affectedCount = articleRepository.createArticle(articleDTO);
        return articleDTO;
    }

    /* TODO Spring Context - member needed. */
    public ArticleDTO modifyArticle(Long articleId ,ArticleDTO articleDTO) {
        articleDTO.setArticleId(articleId);
        // Security Context.
        articleDTO.setMemberDTO(MemberDTO.builder().memberId(1L).build());
        int affectedCount = articleRepository.modifyArticle(articleDTO);
        return articleDTO;
    }

    public void deleteArticle(Long articleId) {
        upvotedArticleRepository.delete(articleId);
        articleRepository.deleteById(articleId);
    }

}
