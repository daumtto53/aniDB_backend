package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherDTO;
import com.aniDB.aniDB_backend.dto.entity.publisher.PublisherPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("")
public class PublisherController {
//    private final PublisherService publisherService;
//
//    @GetMapping("/discover/publisher")
//    public ResponseEntity<PageResultDTO<PublisherPageDTO, PublisherPageDTO>> discoverPublisher(
//            @RequestParam(value = "type", required = false) String type,
//            @RequestParam(value = "page", required = false) int page,
//            @RequestParam(value = "option", required = false) String option,
//            @RequestParam(value = "searchQuery", required = false) String searchQuery
//    ) {
//        PageResultDTO<PublisherPageDTO, PublisherPageDTO> pageResult = publisherService.getPageResult(Integer.valueOf(page));
//        return ResponseEntity.ok(pageResult);
//
//    }
}
