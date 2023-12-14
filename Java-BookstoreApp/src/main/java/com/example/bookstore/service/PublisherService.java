package com.example.bookstore.service;

import com.example.bookstore.dto.PublisherDto;
import java.util.List;

public interface PublisherService {

    List<PublisherDto> getAllPublishers();

    PublisherDto getPublisherById(Long id);

    PublisherDto createPublisher(PublisherDto publisherDto);

    PublisherDto updatePublisher(Long id, PublisherDto publisherDto);

    void deletePublisher(Long id);
}
