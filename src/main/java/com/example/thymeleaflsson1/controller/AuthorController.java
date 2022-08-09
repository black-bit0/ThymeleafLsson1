package com.example.thymeleaflsson1.controller;

import com.example.thymeleaflsson1.model.Author;
import com.example.thymeleaflsson1.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value ="/new", method = RequestMethod.GET)
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author/saveAuthor";
    }

    @PostMapping()
    public String create(@ModelAttribute("author") Author author) {
        authorService.save(author);
        return "redirect:/";
    }

    @RequestMapping(value = "/most_popular", method = RequestMethod.GET)
    public String index(Model md){
       List<Author> list = new ArrayList<>();
        list.add(authorService.getMostPopularAuthor());
        md.addAttribute("list",list);

        return "author/mostPopular";
    }
}
