package com.example.bookstore.mapper;

import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.entity.Genre;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public GenreMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GenreDto toDto(Genre genre) {
        return modelMapper.map(genre, GenreDto.class);
    }

    public Genre toEntity(GenreDto genreDto) {
        return modelMapper.map(genreDto, Genre.class);
    }
}
