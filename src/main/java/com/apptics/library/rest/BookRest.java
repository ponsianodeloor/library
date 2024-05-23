package com.apptics.library.rest;

import com.apptics.library.model.Book;
import com.apptics.library.model.Category;
import com.apptics.library.service.BookService;
import com.apptics.library.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Book", description = "API para gestion de libros")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class BookRest {

    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/books", produces = "application/json")
    public ResponseEntity<?> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping(value = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/books", produces = "application/json")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @PutMapping(value = "/books", produces = "application/json")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
    }

    @DeleteMapping(value = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/books/search/{title}", produces = "application/json")
    public ResponseEntity<?> searchBookByTitle(@PathVariable String title) {
        return new ResponseEntity<>(bookService.searchBookByTitle(title), HttpStatus.OK);
    }

    @GetMapping(value = "/books/category/{categoryId}", produces = "application/json")
    public ResponseEntity<?> getBooksByCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(bookService.getBooksByCategory(category), HttpStatus.OK);
    }
}
