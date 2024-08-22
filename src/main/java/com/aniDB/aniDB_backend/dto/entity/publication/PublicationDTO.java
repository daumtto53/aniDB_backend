package com.aniDB.aniDB_backend.dto.entity.publication;

import com.aniDB.aniDB_backend.dto.entity.alternative_title.AlternativeTitleDTO;
import com.aniDB.aniDB_backend.dto.entity.anime_adaptation.AnimeAdaptationDTO;
import com.aniDB.aniDB_backend.dto.entity.genre.GenreDTO;
import com.aniDB.aniDB_backend.dto.entity.related_series.RelatedSeriesDTO;
import com.aniDB.aniDB_backend.dto.entity.series_comment.SeriesCommentDTO;
import com.aniDB.aniDB_backend.entity.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PublicationDTO {
    private Long publicationId;
    private String title;
    private String description;
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

    private String seriesType;
    private int upvotes;

    @Builder.Default
    private List<String> genreList = new ArrayList<>();
    @Builder.Default
    private List<String> publisherList = new ArrayList<>();
    @Builder.Default
    private List<AlternativeTitleDTO> alternativeTitleList  = new ArrayList<>();
    @Builder.Default
    private List<RelatedSeriesDTO> relatedSeriesList = new ArrayList<>();
    @Builder.Default
    private List<AnimeAdaptationDTO> animeAdaptationList = new ArrayList<>();
    @Builder.Default
    private List<SeriesCommentDTO> seriesCommentList = new ArrayList<>();
}
