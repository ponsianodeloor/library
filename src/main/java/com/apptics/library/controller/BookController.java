package com.apptics.library.controller;

import com.apptics.library.model.Book;
import com.apptics.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/books")
    public String books(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book/{id}")
    public String book(Model model, @PathVariable Long id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "book";
    }
}
