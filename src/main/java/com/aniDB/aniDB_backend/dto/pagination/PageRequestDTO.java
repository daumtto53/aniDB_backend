package com.aniDB.aniDB_backend.dto.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * RDB에서 Data를 Page Data를 retrieve 하기 위해 직접적으로 RDB에 넘겨주는 DTO.
 * size : page's unit size.
 * offset : page 1, 2, 3...'s offset.
 */
public class PageRequestDTO {
    int page;
    int size;

    public PageRequestDTO(int offset) {
        this.page = offset;
        this.size = 10;
    }

    public PageRequestDTO(int offset, int size) {
        this.page = offset;
        this.size = size;
    }

    public Pageable getPageable() {
        // PageRequest.of(pageNumber, size)
        return PageRequest.of(page - 1, size);
    }

    public Pageable getPageable(Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }

}
