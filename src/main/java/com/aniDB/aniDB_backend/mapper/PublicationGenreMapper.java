package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.PublicationGenre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublicationGenreMapper {
    PublicationGenre getByPublicationIdAndGenreId(@Param("publicationId") Long publicationId, @Param("genreId") Long genreId);
    List<PublicationGenre> getByPublicationId(Long publicationId);
    int insert(PublicationGenre publicationGenre);
    int delete(@Param("publicationId") Long publicationId, @Param("genreId") Long genreId);
}
