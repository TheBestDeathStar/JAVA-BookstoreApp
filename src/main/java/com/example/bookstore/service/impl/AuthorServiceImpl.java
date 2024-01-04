package com.example.bookstore.service.impl;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.entity.Author;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        return authorMapper.toDto(author);
    }

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDto(savedAuthor);
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        // Update existingAuthor fields based on authorDto

        Author updatedAuthor = authorRepository.save(existingAuthor);
        return authorMapper.toDto(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
