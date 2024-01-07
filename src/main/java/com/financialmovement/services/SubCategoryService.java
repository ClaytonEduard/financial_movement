package com.financialmovement.services;

import com.financialmovement.entities.Category;
import com.financialmovement.entities.SubCategory;
import com.financialmovement.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CatergoryService catergoryService;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getAllSubCategories() {
        List<SubCategory> categories = new ArrayList<>();
        subCategoryRepository.findAll().forEach(subCategory -> {
            categories.add(subCategory);
        });
        return categories;
    }


    public SubCategory getSubCategory(Long id) {
        return subCategoryRepository.findById(id).get();
    }

    public SubCategory findSubCategoryDescription(String description) {
        notNull(description, "Descrição é obrigatória!");
        List<SubCategory> subCategories = getAllSubCategories();
        SubCategory sc = subCategories.stream().filter(subCategory -> subCategory.getDescription().equals(description)).findFirst().get();
        return sc;
    }

    public SubCategory saveOrUpdate(SubCategory subCategory, Category categoryId) {
        Category cat = catergoryService.getCategoryById(categoryId.getId());
        subCategory.setCategoryid(cat);
        subCategoryRepository.save(subCategory);
        return subCategory;
    }



}
