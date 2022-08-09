package com.example.thymeleaflsson1.service;

import com.example.thymeleaflsson1.model.Book;
import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> getBooksByAuthorName(String name);

    List<Book> getMostSellingBook();

    List<Book> getMostPublishedBook();

    List<Book> getBooksByAuthorPartName(String partName);

}
