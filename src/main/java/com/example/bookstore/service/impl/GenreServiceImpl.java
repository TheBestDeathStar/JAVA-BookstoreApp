package com.example.bookstore.service.impl;

import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.entity.Genre;
import com.example.bookstore.mapper.GenreMapper;
import com.example.bookstore.repository.GenreRepository;
import com.example.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Autowired
    public GenreServiceImpl(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GenreDto getGenreById(Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));
        return genreMapper.toDto(genre);
    }

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        Genre genre = genreMapper.toEntity(genreDto);
        Genre savedGenre = genreRepository.save(genre);
        return genreMapper.toDto(savedGenre);
    }

    @Override
    public GenreDto updateGenre(Long id, GenreDto genreDto) {
        Genre existingGenre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + id));



        Genre updatedGenre = genreRepository.save(existingGenre);
        return genreMapper.toDto(updatedGenre);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
