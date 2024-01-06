package com.example.bookstore.repository;

import com.example.bookstore.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("SELECT g FROM Genre g JOIN g.books b WHERE b.title = :bookTitle")
    List<Genre> findGenresByBookTitle(@Param("bookTitle") String bookTitle);
}
