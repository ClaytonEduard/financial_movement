package com.financialmovement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.financialmovement.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
