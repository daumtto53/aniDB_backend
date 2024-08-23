package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
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
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "option", required = false) String option,
            @RequestParam(value = "searchQuery", required = false) String searchQuery
    ) {
        PageResultDTO<PublisherPageDTO, PublisherPageDTO> pageResult = publisherService.getPageResult(Integer.valueOf(page));
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping(value = "/info/publisher/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublisherDTO> getPublisherInfo(@PathVariable Long id) {
        PublisherDTO result = publisherService.getPublisherInfo(id);
        return ResponseEntity.ok(result);
    }
}
