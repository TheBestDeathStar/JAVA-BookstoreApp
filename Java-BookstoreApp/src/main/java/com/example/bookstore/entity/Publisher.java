package com.example.bookstore.entity;

import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;


}