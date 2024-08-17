package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Genre;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface GenreMapper {
    Genre getById(Long genreId);
    List<Genre> getAll();
    int countAll();
    int insert(Genre genre);
    int update(Genre genre);
    int delete(Long genreId);
}