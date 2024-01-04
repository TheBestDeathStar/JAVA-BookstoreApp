package com.example.bookstore.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    // Other properties and methods, getters and setters

}