package com.financialmovement.categories.controller;

import com.financialmovement.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;

public
class CategoriesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void getAllCategory() {
        verify(categoryRepository).findAll();
    }

}
