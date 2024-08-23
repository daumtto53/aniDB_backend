package com.aniDB.aniDB_backend.service;

import com.aniDB.aniDB_backend.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PublisherService {
    private final PublisherRepository publisherRepository;

}
