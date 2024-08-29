package com.aniDB.aniDB_backend.dto.entity.advanced_search;

import com.aniDB.aniDB_backend.dto.entity.genre.GenreDTO;
import com.aniDB.aniDB_backend.entity.Genre;
import com.aniDB.aniDB_backend.entity.SeriesType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdvancedSearchFormDTO {
    private List<SeriesType> seriesTypeList;
    private List<GenreDTO> genreList;
}
