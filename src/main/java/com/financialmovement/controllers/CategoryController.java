package com.financialmovement.controllers;

import com.financialmovement.entities.Category;
import com.financialmovement.services.CatergoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CatergoryService catergoryService;

    @GetMapping("/category")
    private List<Category> getAllCategorus() {
        return catergoryService.getAllCategorys();
    }

    @GetMapping("/category/{id}")
    private Category getCategory(@PathVariable("id") long id) {
        return catergoryService.getCategoryById(id);
    }

    @DeleteMapping("category/{id}")
    private void deleteCategory(@PathVariable("id") long id) {
        catergoryService.delete(id);
    }

    @PostMapping("/category")
    private long saveCategory(@RequestBody Category category) {
        catergoryService.saveOrdUpdate(category);
        return category.getId();
    }

    @PutMapping("/category")
    private Category update(@RequestBody Category category) {
        catergoryService.saveOrdUpdate(category);
        return category;
    }

}