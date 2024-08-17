package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlternativeTitle {

    private Long alternativeTitleId;
    private Long publicationId;
    private String alternativeTitle;
    private String language;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


