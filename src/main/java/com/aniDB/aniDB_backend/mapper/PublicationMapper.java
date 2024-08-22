package com.aniDB.aniDB_backend.mapper;

import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.entity.Publication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface PublicationMapper {
    Publication selectPublicationById(Long publicationId);

    List<Publication> selectPublicationByTitle(String title);

    Publication selectPublicationByTitleAndSeriesType(String title, String typeName);
    List<Publication> selectPublicationWithComments(Long publicationId);

    List<Publication> selectAllPublications();

    List<Publication> getPage(Pageable pageable);
    PublicationDTO getPublicationDTOById(Long publicationId);



    int countAllPublications();
    int insertPublication(Publication publication);

    int insertPublicationNecessary(Publication publication);
    int updatePublication(Publication publication);
    int deletePublication(Long publicationId);



}