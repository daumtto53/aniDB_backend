package com.aniDB.aniDB_backend.entity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Publication {

    private Long publicationId;
    private String title;
    private String description;
    private int seriesType;
    @Builder.Default
    private int volumesInOriginCountry= 0;
    @Builder.Default
    private String statusInOriginCountry = "Ongoing"; // Default value "Ongoing"
    private LocalDateTime publishedDate;
    @Builder.Default
    private boolean licensed = false; // Default value false
    @Builder.Default
    private int ranked = 0;
    @Builder.Default
    private double scores = 0.0; // Default value 0.0
    private String coverImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private List<AlternativeTitle> alternativeTitleList;
//    private List<RelatedSeries> relatedSeriesList;
//    private List<Genre> genres;
//    private List<AnimeAdaptation> animeAdaptationList;
//    private List<String> publisherList;
//    private List<SeriesComment> seriesCommentList;
}
