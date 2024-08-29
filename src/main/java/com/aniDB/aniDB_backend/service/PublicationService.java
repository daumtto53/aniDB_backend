package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchFormDTO;
import com.aniDB.aniDB_backend.dto.entity.genre.GenreDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.entity.series_comment.SeriesCommentDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import com.aniDB.aniDB_backend.entity.Genre;
import com.aniDB.aniDB_backend.entity.SeriesType;
import com.aniDB.aniDB_backend.repository.GenreRepository;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import com.aniDB.aniDB_backend.repository.SeriesCommentRepository;
import com.aniDB.aniDB_backend.repository.SeriesTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class PublicationService {

    private final PublicationRepository publicationRepository;
    private final SeriesCommentRepository seriesCommentRepository;

    private final GenreRepository genreRepository;
    private final GenreService genreService;

    private final SeriesTypeRepository seriesTypeRepository;

    /*
        1. Pageable
        2. List<T>, total count << RDB
        3. Page<EN> 객체 생성
        4. Page<EN> 객체를 DTO, PageInfo로 변환하는 클래스.
     */
    public PageResultDTO<PublicationPageDTO, PublicationPageDTO> getPageResult(int page, SearchDTO searchDTO, AdvancedSearchDTO advancedSearchDTO) {
        Pageable pageable = new PageRequestDTO(page).getPageable();
        advancedSearchDTO.convertYearToLocalDateTime();
        log.info(advancedSearchDTO);
        List<PublicationPageDTO> result = publicationRepository.getPage(pageable, searchDTO, advancedSearchDTO);
        int totalCount = publicationRepository.countAll(searchDTO, advancedSearchDTO);

        Function<PublicationPageDTO, PublicationPageDTO> fn = (en -> en);
        Page<PublicationPageDTO> pageImpl = new PageImpl<>(result, pageable, totalCount);
        PageResultDTO<PublicationPageDTO, PublicationPageDTO> pageResultDTO = new PageResultDTO<>(pageImpl, fn);
        return pageResultDTO;
    }

    public PublicationDTO getPublicationById(Long publicationId) {
        PublicationDTO publicationDTOById = publicationRepository.getPublicationDTOById(publicationId);
        /* get CommentList? */
        List<SeriesCommentDTO> seriesCommentDTOS = seriesCommentRepository.selectSeriesCommentDTOByPublicationId(publicationId);
        publicationDTOById.setSeriesCommentList(seriesCommentDTOS);
        return publicationDTOById;
    }

    public AdvancedSearchFormDTO getAdvancedSearchForm() {
        List<Genre> allGenres = genreRepository.getAll();
        List<GenreDTO> allGenreList = allGenres.stream()
                .map(genre -> genreService.convertGenreToGenreDTO(genre) )
                .collect(Collectors.toList());
        List<SeriesType> allSeriesType = seriesTypeRepository.getAllSeriesTypes();
        AdvancedSearchFormDTO advancedSearchFormDTO = AdvancedSearchFormDTO.builder()
                .genreList(allGenreList)
                .seriesTypeList(allSeriesType)
                .build();
        return advancedSearchFormDTO;
    }
}
