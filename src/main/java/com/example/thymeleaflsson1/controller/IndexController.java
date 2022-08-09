package com.example.thymeleaflsson1.controller;

import com.example.thymeleaflsson1.model.Author;
import com.example.thymeleaflsson1.model.Book;
import com.example.thymeleaflsson1.service.AuthorService;
import com.example.thymeleaflsson1.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/inject")
public class IndexController {
    private final AuthorService authorService;
    private final BookService bookService;

    public IndexController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @GetMapping("/inject-all")
    public void inject() {
        Author author1 = new Author();
        author1.setAuthorName("Bob");
        author1.setEmail("bob@email");
        author1.setBirthDate("1970");
        author1.setPhoneNumber("XXX-XXX-XXXX");
        authorService.save(author1);

        Author author2 = new Author();
        author2.setAuthorName("Jack");
        author2.setEmail("Jack@email");
        author2.setBirthDate("1970");
        author2.setPhoneNumber("XXX-XXX-XXXX");
        authorService.save(author2);

        Book book1 = new Book();
        book1.setBookName("book1");
        book1.setAuthorId(1L);
        book1.setPublishedAmount(BigInteger.valueOf(100));
        book1.setSoldAmount(BigInteger.valueOf(100));
        bookService.save(book1);

        Book book2 = new Book();
        book2.setBookName("book2");
        book2.setAuthorId(1L);
        book2.setPublishedAmount(BigInteger.valueOf(90));
        book2.setSoldAmount(BigInteger.valueOf(90));
        bookService.save(book2);

        Book book3 = new Book();
        book3.setBookName("book3");
        book3.setAuthorId(1L);
        book3.setPublishedAmount(BigInteger.valueOf(90));
        book3.setSoldAmount(BigInteger.valueOf(90));
        bookService.save(book3);

        Book book4 = new Book();
        book4.setBookName("book4");
        book4.setAuthorId(2L);
        book4.setPublishedAmount(BigInteger.valueOf(150));
        book4.setSoldAmount(BigInteger.valueOf(110));
        bookService.save(book4);

        Book book5 = new Book();
        book5.setBookName("book5");
        book5.setAuthorId(2L);
        book5.setPublishedAmount(BigInteger.valueOf(80));
        book5.setSoldAmount(BigInteger.valueOf(45));
        bookService.save(book5);

    }

    @GetMapping("/by-id")
    public Optional<Author> getById(@RequestParam long id) {
        return authorService.getAuthorById(id);
    }
}
