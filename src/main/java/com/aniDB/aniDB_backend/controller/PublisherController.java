package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.advanced_search.AdvancedSearchDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.dto.search.SearchDTO;
import com.aniDB.aniDB_backend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("")
public class PublisherController {
    private final PublisherService publisherService;

    @GetMapping(value = "/discover/publisher", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PublisherPageDTO, PublisherPageDTO>> discoverPublisher(
            @RequestParam(value = "page", required = false) int page,
            @ModelAttribute AdvancedSearchDTO advancedSearchDTO,
            @ModelAttribute SearchDTO searchDTO
    ) {
        PageResultDTO<PublisherPageDTO, PublisherPageDTO> pageResult = publisherService.getPageResult(Integer.valueOf(page), searchDTO, advancedSearchDTO);
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping(value = "/info/publisher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> getPublisherInfo(@PathVariable Long id) {
        log.info("getPublisherInfo");
        PublisherDTO result = publisherService.getPublisherInfo(id);
        return ResponseEntity.ok(result);
    }
}
