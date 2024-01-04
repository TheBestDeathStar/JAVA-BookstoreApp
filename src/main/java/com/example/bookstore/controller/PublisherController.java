package com.example.bookstore.controller;

import com.example.bookstore.dto.PublisherDto;
import com.example.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<PublisherDto> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }

    @PostMapping
    public PublisherDto createPublisher(@RequestBody PublisherDto publisherDto) {
        return publisherService.createPublisher(publisherDto);
    }

    @PutMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable Long id, @RequestBody PublisherDto publisherDto) {
        return publisherService.updatePublisher(id, publisherDto);
    }

    @DeleteMapping("/{id}")
    public void deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
    }
}