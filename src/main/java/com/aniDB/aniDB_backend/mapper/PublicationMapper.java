package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.entity.Publication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PublicationMapper {
    Publication selectPublicationById(Long publicationId);

    List<Publication> selectPublicationByTitle(String title);

    Publication selectPublicationByTitleAndSeriesType(String title, String typeName);

    List<Publication> selectAllPublications();

    int countAllPublications();
    int insertPublication(Publication publication);

    int insertPublicationNecessary(Publication publication);
    int updatePublication(Publication publication);
    int deletePublication(Long publicationId);

}