package com.example.books_store.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.*;

@Data
@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String author;
    @Column(nullable = true, name = "publicationYear")
    private int publicationYear;
}
