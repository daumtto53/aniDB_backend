package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.AlternativeTitle;
import com.aniDB.aniDB_backend.mapper.AlternativeTitleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AlternativeTitleRepository {

    private final AlternativeTitleMapper alternativeTitleMapper;
    AlternativeTitle getAlternativeTitleById(Long alternativeTitleId, Long publicationId){
        return alternativeTitleMapper.getAlternativeTitleById(alternativeTitleId, publicationId);
    }
    List<AlternativeTitle> getAlternativeTitlesByPublicationId(Long publicationId){
        return alternativeTitleMapper.getAlternativeTitlesByPublicationId(publicationId);
    }
    void insertAlternativeTitle(AlternativeTitle alternativeTitle) {
        alternativeTitleMapper.insertAlternativeTitle(alternativeTitle);
    }
    int updateAlternativeTitle(AlternativeTitle alternativeTitle) {
        return alternativeTitleMapper.updateAlternativeTitle(alternativeTitle);
    }
    int deleteAlternativeTitle(Long alternativeTitleId, Long publicationId) {
        return alternativeTitleMapper.deleteAlternativeTitle(alternativeTitleId, publicationId);
    }
}