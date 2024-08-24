package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.comment.CommentDTO;
import com.aniDB.aniDB_backend.mapper.UpvotedCommentMapper;
import com.aniDB.aniDB_backend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UpvotedCommentMapper upvotedCommentMapper;

    public CommentDTO createComment(Long articleId, CommentDTO commentDTO) {
        commentDTO.setArticleId(articleId);
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

    public void deleteComment(Long commentId) {
        upvotedCommentMapper.deleteUpvotedComment(commentId);
        commentRepository.deleteById(commentId);
    }
}
