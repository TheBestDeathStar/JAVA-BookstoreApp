package com.example.bookstore.service.impl;

import com.example.bookstore.dto.PublisherDto;
import com.example.bookstore.entity.Publisher;
import com.example.bookstore.mapper.PublisherMapper;
import com.example.bookstore.repository.PublisherRepository;
import com.example.bookstore.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Autowired
    public PublisherServiceImpl(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public List<PublisherDto> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers.stream()
                .map(publisherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDto getPublisherById(Long id) {
        Publisher publisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));
        return publisherMapper.toDto(publisher);
    }

    @Override
    public PublisherDto createPublisher(PublisherDto publisherDto) {
        Publisher publisher = publisherMapper.toEntity(publisherDto);
        Publisher savedPublisher = publisherRepository.save(publisher);
        return publisherMapper.toDto(savedPublisher);
    }

    @Override
    public PublisherDto updatePublisher(Long id, PublisherDto publisherDto) {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

        // Update existingPublisher fields based on publisherDto

        Publisher updatedPublisher = publisherRepository.save(existingPublisher);
        return publisherMapper.toDto(updatedPublisher);
    }

    @Override
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}

