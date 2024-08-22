package com.aniDB.aniDB_backend.dto.pagination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
public class PageResultDTO<EN, DTO> {
    private List<DTO> dtoList;
    private PageInfoDTO pageInfoDTO;

    /*
        1. Pageable
        2. PageImpl<T>(repository.findAll()==List<T>, Pageable, count);
        3. PageResultDTO: Page객체를 API Endpoint에 전달하기 위해 DTO + Page 정보를 넘겨주는 개체.
     */
    public PageResultDTO(Page<EN> result, Function<EN, DTO> entityToDTO) {
        dtoList = result.stream()
                .map(entityToDTO).collect(Collectors.toList());
        pageInfoDTO = new PageInfoDTO(result.getPageable(), result.getTotalPages());
    }
}
