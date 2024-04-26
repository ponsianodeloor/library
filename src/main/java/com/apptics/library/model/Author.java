package com.apptics.library.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    private String bio;
    private String website;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "authors", cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<Book>();
}