package com.example.thymeleaflsson1.service;

import com.example.thymeleaflsson1.model.Author;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);

    Optional<Author> getAuthorById(Long id);

    Author getMostPopularAuthor();
}
