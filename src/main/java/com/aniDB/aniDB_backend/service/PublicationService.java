package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.dto.pagination.PageRequestDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.entity.Publication;
import com.aniDB.aniDB_backend.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class PublicationService {

    private final PublicationRepository publicationRepository;

    /*
        1. Pageable
        2. List<T>, total count << RDB
        3. Page<EN> 객체 생성
        4. Page<EN> 객체를 DTO, PageInfo로 변환하는 클래스.
     */
    public PageResultDTO<Publication, Publication> getPageResult(int page) {
        Pageable pageable = new PageRequestDTO(page).getPageable(null);
        List<Publication> result = publicationRepository.getPage(pageable);
        int totalCount = publicationRepository.countAll();
        Function<Publication, Publication> fn = (en -> en);
        Page<Publication> pageimpl = new PageImpl<>(result, pageable, totalCount);
        PageResultDTO<Publication, Publication> pageResultDTO = new PageResultDTO<>(pageimpl, fn);
        return pageResultDTO;
    }
}
