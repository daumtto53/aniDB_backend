package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.comment.CommentDTO;
import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.entity.Member;
import com.aniDB.aniDB_backend.mapper.UpvotedCommentMapper;
import com.aniDB.aniDB_backend.repository.CommentRepository;
import com.aniDB.aniDB_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UpvotedCommentMapper upvotedCommentMapper;
    private final MemberRepository memberRepository;

    public CommentDTO createComment(Long articleId, CommentDTO commentDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Member member = memberRepository.findByUsername(username);

        commentDTO.setArticleId(articleId);
        commentDTO.setMemberDTO(MemberDTO.builder().memberId(member.getMemberId()).build());
        // Member setting.
        commentRepository.createComment(commentDTO);
        return commentDTO;
    }

    public CommentDTO updateComment(Long commentId, Long articleId, CommentDTO commentDTO) {
        commentDTO.setArticleId(articleId);
        commentDTO.setCommentId(commentId);
        int update = commentRepository.update(commentDTO);
        return commentDTO;
    }

    public void deleteCommentByCommentId(Long commentId) {
        upvotedCommentMapper.deleteUpvotedCommentByCommentId(commentId);
        commentRepository.deleteById(commentId);
    }
}
