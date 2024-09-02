package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.article.ArticleDTO;
import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.entity.Article;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.repository.ArticleRepository;
import com.aniDB.aniDB_backend.repository.CommentRepository;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import com.aniDB.aniDB_backend.repository.UpvotedArticleRepository;
import com.aniDB.aniDB_backend.security.model.CustomOAuth2User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final UpvotedArticleRepository upvotedArticleRepository;
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;

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
        articleRepository.incrementViews(articleId);
        return articleRepository.getArticleDTOById(articleId);
    }

     /* TODO Spring Context - member needed. */
    public ArticleDTO createArticle(Long publicationId, ArticleDTO articleDTO) {
        articleDTO.setPublicationId(publicationId);
        // Securtiy Context.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberRepository.findByUsername(username);
        articleDTO.setMemberDTO(MemberDTO.builder().memberId(member.getMemberId()).build());
        int affectedCount = articleRepository.createArticle(articleDTO);
        return articleDTO;
    }

    /* TODO Spring Context - member needed. */
    public ArticleDTO modifyArticle(Long articleId ,ArticleDTO articleDTO) {
        articleDTO.setArticleId(articleId);
        // Security Context.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberRepository.findByUsername(username);
        articleDTO.setMemberDTO(MemberDTO.builder().memberId(member.getMemberId()).build());
        int affectedCount = articleRepository.modifyArticle(articleDTO);
        return articleDTO;
    }

    public void deleteArticle(Long articleId) {
        upvotedArticleRepository.deleteByArticleId(articleId);
        commentRepository.deleteByArticleId(articleId);
        articleRepository.deleteById(articleId);
    }

}
