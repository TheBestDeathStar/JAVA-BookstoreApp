package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;



}