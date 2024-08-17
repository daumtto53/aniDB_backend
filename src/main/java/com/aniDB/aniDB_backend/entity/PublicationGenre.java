package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PublicationGenre {
    private Long publicationId;
    private Long genreId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
