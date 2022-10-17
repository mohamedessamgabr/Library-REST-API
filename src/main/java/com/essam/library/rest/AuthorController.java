package com.essam.library.rest;

import com.essam.library.model.Author;
import com.essam.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return authorService.findAll();
    }

    @PostMapping("/add-author")
    public Author addAuthor(@RequestBody Author author) {
        return authorService.save(author);
    }


}
