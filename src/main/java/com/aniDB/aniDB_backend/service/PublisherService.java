package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import com.aniDB.aniDB_backend.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

    public PageResultDTO<PublisherPageDTO, PublisherPageDTO> getPageResult(int page, SearchDTO searchDTO, AdvancedSearchDTO advancedSearchDTO) {
        Pageable pageable = new PageRequestDTO(page).getPageable();
        List<PublisherPageDTO> result = publisherRepository.getPage(pageable, searchDTO, advancedSearchDTO);
        int totalCount = publisherRepository.countAll();
        Function<PublisherPageDTO, PublisherPageDTO> fn = (en -> en);
        Page<PublisherPageDTO> pageImpl = new PageImpl<>(result, pageable, totalCount);
        PageResultDTO<PublisherPageDTO, PublisherPageDTO> pageResultDTO = new PageResultDTO<>(pageImpl, fn);
        return pageResultDTO;
    }

    public PublisherDTO getPublisherInfo(Long publisherId) {
        PublisherDTO result = publisherRepository.getPublisherDTOById(publisherId);
        return result;
    }

}
