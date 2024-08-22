package com.aniDB.aniDB_backend.dto.pagination;

import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Getter
@Setter
@ToString
public class PageInfoDTO {
    private int totalPage;
    private int size;
    private int page;
    private int start;
    private int end;
    private boolean prev;
    private boolean next;
    private List<Integer> pageList;

    public PageInfoDTO(Pageable pageable, int totalPage) {
        this.page = pageable.getPageNumber() + 1;
        this.size = pageable.getPageSize();
        this.totalPage = totalPage;

        int tempEnd = (int)Math.ceil(page / 10.0) * 10;
        int start = tempEnd - 9;
        prev = start > 1;
        end = totalPage < tempEnd ? totalPage : tempEnd;
        next = totalPage > tempEnd;
    }
}
