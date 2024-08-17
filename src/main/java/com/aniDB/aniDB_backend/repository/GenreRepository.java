package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Genre;
import com.aniDB.aniDB_backend.mapper.GenreMapper;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GenreRepository {

    private final GenreMapper genreMapper;

    public Genre getById(Long genreId) {
        return genreMapper.getById(genreId);
    }

    public List<Genre> getAll() {
        return genreMapper.getAll();
    }

    public int create(Genre genre) {
        return genreMapper.insert(genre);
    }

    public int update(Genre genre) {
        return genreMapper.update(genre);
    }

    public int delete(Long genreId) {
        return genreMapper.delete(genreId);
    }
}
