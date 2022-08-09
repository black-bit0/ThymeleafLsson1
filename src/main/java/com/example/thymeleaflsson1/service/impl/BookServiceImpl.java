package com.example.thymeleaflsson1.service.impl;

import com.example.thymeleaflsson1.model.Book;
import com.example.thymeleaflsson1.repository.BookRepository;
import com.example.thymeleaflsson1.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        return  repository.save(book);
    }

    @Override
    public List<Book> getBooksByAuthorName(String name) {
        return repository.getBooksByAuthorName(name);
    }

    @Override
    public List<Book> getMostSellingBook() {
        return repository.getMostSellingBook();
    }

    @Override
    public List<Book> getMostPublishedBook() {
        return repository.getMostPublishedBook();
    }

    @Override
    public List<Book> getBooksByAuthorPartName(String partName) {
        return repository.getBooksByAuthorPartName(partName);
    }

}
