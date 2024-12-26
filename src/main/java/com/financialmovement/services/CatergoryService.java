package com.financialmovement.services;

import com.financialmovement.entities.Category;
import com.financialmovement.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
public class CatergoryService {

    @Autowired
    private CategoryRepository repository;

    public CatergoryService(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    public List<Category> getAllCategorys() {
        List<Category> categorys = new ArrayList<>();
        repository.findAll().forEach(category1 -> categorys.add(category1));
        return categorys;
    }

    // pesquisar por id
    public Category getCategoryById(long id) {
        return repository.findById(id).get();
    }

    // pesquisar por description
    public List<Category> findCategoriesForDescription(String description) {
        notNull(description, "Descrição é obrigatória!");
        List<Category> categories = getAllCategorys();
        categories.stream().filter(category -> category.getDescription().equals(description)).collect(Collectors.toList());
        return categories;
    }

    public Category findCategoryDescription(String description) {
        notNull(description, "Descrição é obrigatória!");
        List<Category> categories = getAllCategorys();
        Category c = (Category) categories.stream().filter(category -> category.getDescription().equals(description)).findFirst().get();
        return c;
    }

    // save our update
    public Category saveOrdUpdate(Category category) {
        repository.save(category);
        return category;
    }

    // deletete
    public void delete(long id) {
        repository.deleteById(id);
    }

    // update a record
    public void update(Category category, long id) {
        repository.save(category);
    }

}
