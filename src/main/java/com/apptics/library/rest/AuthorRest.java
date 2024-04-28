package com.apptics.library.rest;

import com.apptics.library.model.Author;
import com.apptics.library.service.AuthorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Author", description = "API para gestion de autores de libros")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class AuthorRest {
    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/authors", produces = "application/json")
    public ResponseEntity<?> getAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping(value = "/authors/{id}", produces = "application/json")
    public ResponseEntity<?> getAuthorById(@PathVariable Long id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/authors", produces = "application/json")
    public ResponseEntity<?> saveAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.CREATED);
    }

    @PutMapping(value = "/authors", produces = "application/json")
    public ResponseEntity<?> updateAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.saveAuthor(author), HttpStatus.OK);
    }

    @DeleteMapping(value = "/authors/{id}", produces = "application/json")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
