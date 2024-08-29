package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchFormDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import com.aniDB.aniDB_backend.service.PublicationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Log4j2
public class PublicationController {
    private final PublicationService publicationService;

    /*
        쿼리 파라미터로 값들을 받아올 것.
     */
    @GetMapping(value = "/discover/publication", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PublicationPageDTO, PublicationPageDTO>> discoverPublication(
            @RequestParam("page") String page,
            @ModelAttribute AdvancedSearchDTO advancedSearchDTO,
            @ModelAttribute SearchDTO searchDTO
    ) {
        log.info("Model Attribute : advancedSearchDTO = {}", advancedSearchDTO);
        log.info("SearchDTO: {}", searchDTO);

        PageResultDTO<PublicationPageDTO, PublicationPageDTO> pageResult = publicationService.getPageResult(Integer.valueOf(page), searchDTO, advancedSearchDTO);
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping(value = "/info/publication/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublicationDTO> getPublicationInfo(
            @PathVariable(value = "id") Long id
    ) {
        PublicationDTO result = publicationService.getPublicationById(id);
        return ResponseEntity.ok(result);
    }

    /*
        pageResult + redirect URL까지 반환할 것.
        redirectURL은 /discover/publication으로 하여, 그곳에서 pagination과 함께 기타 등등 할 것.
     */

    @GetMapping("/advancedSearch")
    public ResponseEntity getAdvancedSearchForm() {
        AdvancedSearchFormDTO advancedSearchForm = publicationService.getAdvancedSearchForm();
        return ResponseEntity.ok(advancedSearchForm);
    }

    @PostMapping("/advancedSearch")
    public ResponseEntity discoverPublicationByAdvancedSearch(
            @RequestBody AdvancedSearchDTO advancedSearchDTO
    ) {
        log.info("request Body  = {}", advancedSearchDTO);
        SearchDTO searchDTO = SearchDTO.builder().build();
        PageResultDTO<PublicationPageDTO, PublicationPageDTO> pageResult = publicationService.getPageResult(1, searchDTO, advancedSearchDTO);
        Map<String, Object> response = new HashMap<>();
        response.put("redirectUrl", "/discover/publication");
        response.put("data", pageResult);
        log.info("pageResult in advancedSearch ={}", pageResult);
        return ResponseEntity.ok(response);
    }

}
