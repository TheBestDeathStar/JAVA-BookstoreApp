package com.example.bookstore.controller;

import com.example.bookstore.dto.GenreDto;
import com.example.bookstore.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDto> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public GenreDto getGenreById(@PathVariable Long id) {
        return genreService.getGenreById(id);
    }

    @PostMapping
    public GenreDto createGenre(@RequestBody GenreDto genreDto) {
        return genreService.createGenre(genreDto);
    }

    @PutMapping("/{id}")
    public GenreDto updateGenre(@PathVariable Long id, @RequestBody GenreDto genreDto) {
        return genreService.updateGenre(id, genreDto);
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}