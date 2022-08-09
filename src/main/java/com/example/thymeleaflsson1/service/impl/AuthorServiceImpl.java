package com.example.thymeleaflsson1.service.impl;

import com.example.thymeleaflsson1.model.Author;
import com.example.thymeleaflsson1.repository.AuthorRepository;
import com.example.thymeleaflsson1.service.AuthorService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }


    @Override
    public Author save(Author author) {
        return repository.save(author);
    }

    @Override
    public Optional<Author> getAuthorById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Author getMostPopularAuthor() {
        Author tempAuthor = new Author();
        String[] tempArray = repository.getMostPopularAuthor().get().split(",");
        tempAuthor.setId(Long.valueOf(tempArray[1]));
        tempAuthor.setAuthorName(tempArray[2]);
        tempAuthor.setBirthDate(tempArray[3]);
        tempAuthor.setEmail(tempArray[4]);
        tempAuthor.setPhoneNumber(tempArray[5]);

        return tempAuthor;
    }


}
