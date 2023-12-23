package com.financialmovement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financialmovement.entities.Category;
import com.financialmovement.repositories.CategoryRepository;

@Service
public class CatergoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> getAllCategorys() {
        List<Category> categorys = new ArrayList<>();
        repository.findAll().forEach(category1 -> categorys.add(category1));
        return categorys;
    }

    // pesquisar por id
    public Category getCategoryById(long id) {
        return repository.findById(id).get();
    }

    // save our update
    public void saveOrdUpdate(Category category) {
        repository.save(category);
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
