package com.aniDB.aniDB_backend.dto.entity.article;

import com.aniDB.aniDB_backend.dto.entity.member.MemberDTO;
import com.aniDB.aniDB_backend.entity.Comment;
import com.aniDB.aniDB_backend.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArticleDTO {
    private Long articleId;
    private MemberDTO memberDTO;
    private Long publicationId;
    private Long animeId;
    private String title;
    private String content;
    @Builder.Default
    private Integer views = 0;
    @Builder.Default
    private Integer upvotes = 0;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private List<Comment> commentList;
}