package com.financialmovement.categories.repositories;

import com.financialmovement.entities.Category;
import com.financialmovement.repositories.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")// anotacao para buscar o arquivo application-test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    @DisplayName("Should get catgory successfull for DB")
    void findByCategorySucess() {
        Category category = new Category();
        category.setDescription("Investimentos");
        Category categorySave = createCategory(category);
        // verificacao
        assertThat(categorySave).isNotNull();
        assertThat(categorySave.getId()).isNotNull();
        assertThat(categorySave.getDescription()).isEqualTo(category.getDescription());

    }

    private Category createCategory(Category category) {
        Category cat = new Category();
        cat.setDescription(category.getDescription());
        this.categoryRepository.save(cat);
        return cat;
    }


}