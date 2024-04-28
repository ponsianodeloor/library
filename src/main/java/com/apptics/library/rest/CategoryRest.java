package com.apptics.library.rest;

import com.apptics.library.model.Category;
import com.apptics.library.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Category", description = "API para gestion de categorias para libros")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class CategoryRest {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping(value = "/categories/{id}", produces = "application/json")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<?> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @PutMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<?> updateCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.OK);
    }

    @DeleteMapping(value = "/categories/{id}", produces = "application/json")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
