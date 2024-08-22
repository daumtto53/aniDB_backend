package com.aniDB.aniDB_backend.dto.entity.publication;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PublicationPageDTO {
    private Long publicationId;
    private String title;
    @Builder.Default
    private int ranked = 0;
    @Builder.Default
    private double scores = 0.0; // Default value 0.0
    private String coverImageUrl;
    private String seriesType;
    private int upvotes;
}
