package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoriesRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    private Category category;

    @BeforeEach
    void setUp() {
        // Initialize a sample category
        category = new Category.Builder()
                .setName("Electronics")
                .build();
    }

    @Test
    void create() {
        Category savedCategory = categoryService.create(category);
        assertNotNull(savedCategory);
        assertEquals(category.getName(), savedCategory.getName());
    }

    @Test
    void read() {
        Category savedCategory = categoryService.create(category);
        Optional<Category> foundCategory = Optional.ofNullable(categoryService.read(savedCategory.getId()));
        assertTrue(foundCategory.isPresent());
        assertEquals(savedCategory.getName(), foundCategory.get().getName());
    }

    @Test
    void update() {
        Category savedCategory = categoryService.create(category);
        Category updatedCategory = new Category.Builder()
                .copy(savedCategory)
                .setName("Updated name")
                .build();
        Category result = categoryService.update(updatedCategory);
        assertEquals("Updated description", result.getName());
    }

    @Test
    void findAll() {
        categoryService.create(category);
        List<Category> categoryList = categoryService.findAll();

        assertFalse(categoryList.isEmpty());
        assertTrue(categoryList.stream().anyMatch(cat -> cat.getName().equals(category.getName())));
    }
}