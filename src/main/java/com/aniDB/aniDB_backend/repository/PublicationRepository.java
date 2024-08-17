package com.aniDB.aniDB_backend.repository;

import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.mapper.PublicationMapper;

import java.util.List;

public class PublicationRepository {
    private final PublicationMapper publicationMapper;

    public PublicationRepository(PublicationMapper publicationMapper) {
        this.publicationMapper = publicationMapper;
    }

    /**
     * Finds a publication by its ID.
     * @param publicationId the ID of the publication.
     * @return the Publication object if found, otherwise null.
     */
    public Publication findById(Long publicationId) {
        return publicationMapper.selectPublicationById(publicationId);
    }

    /**
     * Finds publications by their title.
     * @param title the title of the publication.
     * @return a list of Publication objects matching the title.
     */
    public List<Publication> findByTitle(String title) {
        return publicationMapper.selectPublicationByTitle(title);
    }

    /**
     * Finds a publication by its title and series type.
     * @param title the title of the publication.
     * @param typeName the type of the series.
     * @return the Publication object if found, otherwise null.
     */
    public Publication findByTitleAndSeriesType(String title, String typeName) {
        return publicationMapper.selectPublicationByTitleAndSeriesType(title, typeName);
    }

    /**
     * Retrieves all publications.
     * @return a list of all Publication objects.
     */
    public List<Publication> findAll() {
        return publicationMapper.selectAllPublications();
    }

    /**
     * Counts all publications.
     * @return the number of publications.
     */
    public int countAll() {
        return publicationMapper.countAllPublications();
    }

    /**
     * Inserts a new publication into the database.
     * @param publication the Publication object to insert.
     * @return the number of rows affected.
     */
    public int save(Publication publication) {
        return publicationMapper.insertPublication(publication);
    }

    /**
     * Inserts a new publication with necessary fields only.
     * @param publication the Publication object to insert.
     * @return the number of rows affected.
     */
    public int saveNecessary(Publication publication) {
        return publicationMapper.insertPublicationNecessary(publication);
    }

    /**
     * Updates an existing publication in the database.
     * @param publication the Publication object with updated data.
     * @return the number of rows affected.
     */
    public int update(Publication publication) {
        return publicationMapper.updatePublication(publication);
    }

    /**
     * Deletes a publication by its ID.
     * @param publicationId the ID of the publication to delete.
     * @return the number of rows affected.
     */
    public int deleteById(Long publicationId) {
        return publicationMapper.deletePublication(publicationId);
    }
}
