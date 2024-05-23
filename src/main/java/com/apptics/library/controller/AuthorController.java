package com.apptics.library.controller;

import com.apptics.library.model.Author;
import com.apptics.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public String authors(Model model) {
        List<Author> authors = authorService.getAllAuthors();
        model.addAttribute("authors", authors);
        return "author/authors";
    }

    @GetMapping("/add-author")
    public String addAuthor(Author author) {
        return "author/add-author";
    }

    @PostMapping("/save-author")
    public String saveAuthor(Author author, Model model) {
        authorService.saveAuthor(author);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "author/authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Model model) {
        authorService.getAuthorById(id);
        model.addAttribute("author", authorService.getAuthorById(id));
        return "author/update-author";
    }

    @PostMapping("/save-update-author/{id}")
    public String updateAuthor(@PathVariable Long id, Author author, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "author/update-author";
        }

        if (authorService.getAuthorById(id) != null) {
            authorService.updateAuthor(author);
        }else {
            return "author/update-author";
        }

        model.addAttribute("authors", authorService.getAllAuthors());
        return "author/authors";
    }

    @GetMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable Long id, Model model) {
        authorService.deleteAuthor(id);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "author/authors";
    }
}
