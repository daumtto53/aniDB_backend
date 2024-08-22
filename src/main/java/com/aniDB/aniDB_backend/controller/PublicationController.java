package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.publication.PublicationDTO;
import com.aniDB.aniDB_backend.dto.entity.publication.PublicationPageDTO;
import com.aniDB.aniDB_backend.dto.pagination.PageResultDTO;
import com.aniDB.aniDB_backend.service.PublicationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
@Log4j2
public class PublicationController {
    private final PublicationService publicationService;

    @GetMapping(value = "/discover/publication", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResultDTO<PublicationPageDTO, PublicationPageDTO>> discoverPublication(
            @RequestParam(value = "type", required = false) String type,
            @RequestParam("page") String page,
            @RequestParam(value = "option", required = false) String option,
            @RequestParam(value = "searchQuery", required = false) String searchQuery
    ) {
        PageResultDTO<PublicationPageDTO, PublicationPageDTO> pageResult = publicationService.getPageResult(Integer.valueOf(page));
        return ResponseEntity.ok(pageResult);
    }

    @GetMapping(value = "/info/publication/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PublicationDTO>  getPublicationInfo(
            @PathVariable(value = "id") Long id
    ) {
        PublicationDTO result = publicationService.getPublicationById(id);
        return ResponseEntity.ok(result);
    }
}
