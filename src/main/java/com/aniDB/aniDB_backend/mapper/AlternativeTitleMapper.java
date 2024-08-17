package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.AlternativeTitle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlternativeTitleMapper {
    AlternativeTitle getAlternativeTitleById(Long alternativeTitleId, Long publicationId);
    List<AlternativeTitle> getAlternativeTitlesByPublicationId(Long publicationId);
    int insertAlternativeTitle(AlternativeTitle alternativeTitle);
    int updateAlternativeTitle(AlternativeTitle alternativeTitle);
    int deleteAlternativeTitle(@Param("alternativeTitleId") Long alternativeTitleId, @Param("publicationId") Long publicationId);
}