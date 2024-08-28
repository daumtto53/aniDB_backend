package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.mapper.PublicationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PublicationRepository {

    private final PublicationMapper publicationMapper;

    /**
     * Finds a publication by its ID.
     * @param publicationId the ID of the publication.
     * @return the Publication object if found, otherwise null.
     */
    @Transactional
    public Publication findById(Long publicationId) {
        return publicationMapper.selectPublicationById(publicationId);
    }


    /**
     * Finds publications by their title.
     * @param title the title of the publication.
     * @return a list of Publication objects matching the title.
     */
    @Transactional
    public List<Publication> findByTitle(String title) {
        return publicationMapper.selectPublicationByTitle(title);
    }

    /**
     * Finds a publication by its title and series type.
     * @param title the title of the publication.
     * @param typeName the type of the series.
     * @return the Publication object if found, otherwise null.
     */
    @Transactional
    public Publication findByTitleAndSeriesType(String title, String typeName) {
        return publicationMapper.selectPublicationByTitleAndSeriesType(title, typeName);
    }

    /**
     * Retrieves all publications.
     * @return a list of all Publication objects.
     */
    @Transactional
    public List<Publication> findAll() {
        return publicationMapper.selectAllPublications();
    }



    @Transactional
    public PublicationDTO getPublicationDTOById(Long publicationId) {
        return publicationMapper.getPublicationDTOById(publicationId);
    }


    /**
     * Counts all publications.
     * @return the number of publications.
     */
    @Transactional
    public int countAll(SearchDTO searchDTO, AdvancedSearchDTO advancedSearchDTO) {
        return publicationMapper.countAllPublications(searchDTO, advancedSearchDTO);
    }

    /**
     * Inserts a new publication into the database.
     * @param publication the Publication object to insert.
     * @return the number of rows affected.
     */
    @Transactional
    public int save(Publication publication) {
        return publicationMapper.insertPublication(publication);
    }

    /**
     * Inserts a new publication with necessary fields only.
     * @param publication the Publication object to insert.
     * @return the number of rows affected.
     */
    @Transactional
    public int saveNecessary(Publication publication) {
        return publicationMapper.insertPublicationNecessary(publication);
    }

    /**
     * Updates an existing publication in the database.
     * @param publication the Publication object with updated data.
     * @return the number of rows affected.
     */
    @Transactional
    public int update(Publication publication) {
        return publicationMapper.updatePublication(publication);
    }

    /**
     * Deletes a publication by its ID.
     * @param publicationId the ID of the publication to delete.
     * @return the number of rows affected.
     */
    @Transactional
    public int deleteById(Long publicationId) {
        return publicationMapper.deletePublication(publicationId);
    }


    @Transactional
    public List<PublicationPageDTO> getPage(Pageable pageable, SearchDTO searchDTO, AdvancedSearchDTO advancedSearchDTO) {
        return publicationMapper.getPage(pageable, searchDTO, advancedSearchDTO);
    }
}
