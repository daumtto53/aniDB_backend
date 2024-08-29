package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.genre.GenreDTO;
import com.aniDB.aniDB_backend.entity.Genre;
import com.aniDB.aniDB_backend.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreDTO convertGenreToGenreDTO(Genre genre) {
        return GenreDTO.builder()
                .genreId(genre.getGenreId())
                .genreName(genre.getGenreName())
                .build();
    }
}
