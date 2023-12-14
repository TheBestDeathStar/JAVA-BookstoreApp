package com.example.bookstore.mapper;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.entity.Author;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public AuthorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AuthorDto toDto(Author author) {
        return modelMapper.map(author, AuthorDto.class);
    }

    public Author toEntity(AuthorDto authorDto) {
        return modelMapper.map(authorDto, Author.class);
    }
}
