package com.aniDB.aniDB_backend.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PublicationPublisher {
    private Long publicationId;
    private Long publisherId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
