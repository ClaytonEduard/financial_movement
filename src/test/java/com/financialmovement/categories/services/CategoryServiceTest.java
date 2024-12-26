package com.financialmovement.categories.services;

import com.financialmovement.entities.Category;
import com.financialmovement.repositories.CategoryRepository;
import com.financialmovement.services.CatergoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Testes para o serviço de Categoria")
@DataJpaTest
@ActiveProfiles("test") // anotacao para buscar o arquivo application-test
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryServiceTest {
    @InjectMocks
    CatergoryService catergoryService;

    @Mock
    CategoryRepository categoryRepository;

    Category category;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // teste salvo com sucesso
    @Test
    void saveForSuccess() {
        Category category = new Category();
        category.setDescription("Entrada");
        when(categoryRepository.save(category)).thenReturn(category);
        // acao
        Category category2 = catergoryService.saveOrdUpdate(category);
        // verificacao
        assertThat(category2).isNotNull();
        assertThat(category2.getDescription()).isEqualTo(category.getDescription());
        // assertEquals(category2.getDescription(), "Entrada");
    }

    @Test
    void getAll() {
        List<Category> cat = catergoryService.getAllCategorys();
        cat.forEach(category1 -> {
            category1.getDescription();
        });
        verify(categoryRepository).findAll();

    }

    @Test
    void getById() {
        Category category = new Category();
        category.setDescription("Entrada");

        Category cat = catergoryService.findCategoryDescription("Entrada");

        assertThat(category.getDescription()).isEqualTo(cat.getDescription());
        // assertThat(cat.getId()).isEqualTo(1L);

    }
}
