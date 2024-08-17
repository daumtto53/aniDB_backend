package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.PublicationGenre;
import com.aniDB.aniDB_backend.mapper.PublicationGenreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublicationGenreRepository {

    private final PublicationGenreMapper publicationGenreMapper;

    public PublicationGenre getByIds(Long publicationId, Long genreId) {
        return publicationGenreMapper.getByPublicationIdAndGenreId(publicationId, genreId);
    }

    public List<PublicationGenre> getByTitleId(Long publicationId) {
        return publicationGenreMapper.getByPublicationId(publicationId);
    }

    public int create(PublicationGenre publicationGenre) {
        return publicationGenreMapper.insert(publicationGenre);
    }

    public int delete(Long publicationId, Long genreId) {
        return publicationGenreMapper.delete(publicationId, genreId);
    }
}