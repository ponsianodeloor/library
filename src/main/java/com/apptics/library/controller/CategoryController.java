package com.apptics.library.controller;

import com.apptics.library.model.Category;
import com.apptics.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/add-category")
    public String addCategory(Category category) {
        return "category/add-category";
    }

    @PostMapping("/save-category")
    public String saveCategory(Category category, Model model) {
        categoryService.saveCategory(category);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/update-category/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        categoryService.getCategoryById(id);
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "category/update-category";
    }

    @PostMapping("/save-update-category/{id}")
    public String updateCategory(@PathVariable Long id, Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "category/update-category";
        }
        if (categoryService.getCategoryById(id) != null) {
            categoryService.updateCategory(category);
        } else {
            return "category/update-category";
        }
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/categories";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        categoryService.deleteCategory(id);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "category/categories";
    }


}
