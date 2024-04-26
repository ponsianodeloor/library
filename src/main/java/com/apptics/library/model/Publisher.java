package com.apptics.library.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String name;

    @ManyToMany(mappedBy = "publishers", cascade = {CascadeType.ALL})
    private Set<Book> books = new HashSet<Book>();
}
