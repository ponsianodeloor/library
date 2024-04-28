package com.apptics.library.rest;

import com.apptics.library.model.Publisher;
import com.apptics.library.service.PublisherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Author", description = "API para gestion de autores de libros")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class PublisherRest {
    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "/publishers", produces = "application/json")
    public ResponseEntity<?> getPublishers() {
        return new ResponseEntity<>(publisherService.getAllPublishers(), HttpStatus.OK);
    }

    @GetMapping(value = "/publishers/{id}", produces = "application/json")
    public ResponseEntity<?> getPublisherById(@PathVariable Long id) {
        return new ResponseEntity<>(publisherService.getPublisherById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/publishers", produces = "application/json")
    public ResponseEntity<?> savePublisher(@RequestBody Publisher publisher) {
        return new ResponseEntity<>(publisherService.savePublisher(publisher), HttpStatus.CREATED);
    }

    @PutMapping(value = "/publishers", produces = "application/json")
    public ResponseEntity<?> updatePublisher(@RequestBody Publisher publisher) {
        return new ResponseEntity<>(publisherService.savePublisher(publisher), HttpStatus.OK);
    }

    @DeleteMapping(value = "/publishers/{id}", produces = "application/json")
    public ResponseEntity<?> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
