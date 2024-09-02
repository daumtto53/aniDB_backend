package com.aniDB.aniDB_backend.dto.entity.advanced_search;

import com.aniDB.aniDB_backend.dto.entity.genre.GenreDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdvancedSearchDTO {
    private String title;

    private String publisher;

    private String typeString;

    private Integer startYear;
    private Integer endYear;

    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private List<String> status;

    private Integer startVolume;
    private Integer endVolume;

    private List<String> genreList;

    public AdvancedSearchDTO setAdvancedSearchDTOToDefault() {
        this.title = null;  // or "" if you prefer an empty string
        this.publisher = null;  // or "" if you prefer an empty string
        this.typeString = null;  // or "" if you prefer an empty string
        this.startYear = null;
        this.endYear = null;
        this.status = Collections.emptyList();  // empty list if you want to start with no statuses
        this.startVolume = null;
        this.endVolume = null;
        this.genreList = Collections.emptyList();  // empty list if you want to start with no genres

        return this;
    }

    public void convertYearToLocalDateTime() {
        if (startYear != null)
            startDateTime = Year.of(startYear).atDay(1).atStartOfDay();
        if (endYear != null)
            endDateTime = Year.of(endYear).atMonth(12).atDay(31).atStartOfDay();
    }

    public String getTypeStringForUrl() {
        if (this.typeString != null) {
            if (this.typeString.equals("Light Novel"))
                return "Light%20Novel";
            else
                return this.typeString;
        }
        else
            return null;
    }
}
