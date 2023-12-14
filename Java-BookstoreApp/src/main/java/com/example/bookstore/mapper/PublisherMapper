package com.example.bookstore.mapper;

import com.example.bookstore.dto.PublisherDto;
import com.example.bookstore.entity.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public PublisherMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PublisherDto toDto(Publisher publisher) {
        return modelMapper.map(publisher, PublisherDto.class);
    }

    public Publisher toEntity(PublisherDto publisherDto) {
        return modelMapper.map(publisherDto, Publisher.class);
    }
}
