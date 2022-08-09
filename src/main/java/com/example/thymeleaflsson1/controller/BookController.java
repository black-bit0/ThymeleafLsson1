package com.example.thymeleaflsson1.controller;

import com.example.thymeleaflsson1.model.Book;
import com.example.thymeleaflsson1.model.RequestField;
import com.example.thymeleaflsson1.service.BookService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    RequestField field = new RequestField();
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value ="/new", method = RequestMethod.GET)
    public String newAuthor(Model model) {
        model.addAttribute("book", new Book());
        return "book/saveBook";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/by_name", method = RequestMethod.GET)
    public String getBookByName(Model model, @Param("name") String name) {

        List<Book> list = bookService.getBooksByAuthorName(name);

        model.addAttribute("list", list);
        model.addAttribute("name", name);

        return "book/byName";
    }

    @RequestMapping(value = "/most_selling", method = RequestMethod.GET)
    public String getMostSellingBook(Model model) {
        List<Book> list = bookService.getMostSellingBook();

        model.addAttribute("list", list);
        return "book/mostPublishedOrSellingBook";
    }

    @RequestMapping(value = "/most_published", method = RequestMethod.GET)
    public String getMostPublishedBook(Model model) {
        List<Book> list = bookService.getMostPublishedBook();

        model.addAttribute("list", list);
        return "book/mostPublishedOrSellingBook";
    }


    @RequestMapping(value = "/by_part_name", method = RequestMethod.GET)
    public String getMostPopularBookByAuthorPartName(Model model, @Param("partName") String partName) {
        List<Book> list = bookService.getBooksByAuthorPartName(partName);

        model.addAttribute("list", list);
        model.addAttribute("name", partName);

        return "book/byPartName";
    }
}
