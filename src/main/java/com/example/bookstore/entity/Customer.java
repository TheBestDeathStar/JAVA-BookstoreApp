package com.example.bookstore.entity;

import jakarta.persistence.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;


}