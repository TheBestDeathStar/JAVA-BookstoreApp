package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import java.util.List;

public interface BookService {

    List<BookDto> getAllBooks();

    BookDto getBookById(Long id);

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(Long id, BookDto bookDto);

    void deleteBook(Long id);
}
