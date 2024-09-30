package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.SubCategory;
import za.ac.cput.factory.SubCategoryFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class SubCategoryServiceTest {

    private SubCategory subCategory;

    @Autowired
    private ProductService productService;

    private Category category;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    private Product product;

    @BeforeEach
    void setUp() {
        // Use existing products and categories in the database for testing
        product = productService.read(1L);
        category = categoryService.read(1L);

        // Create a SubCategory without manually setting the ID
        subCategory = SubCategoryFactory.createSubCategory(
                null,
                category,
                "beads",
                product
        );
    }

    @AfterEach
    void tearDown() {
        if (subCategory != null && subCategory.getId() != null) {
            subCategoryService.delete(subCategory.getId());
        }
    }

    @Test
    @Order(1)
    void create() {
        SubCategory created = subCategoryService.create(subCategory);
        assertNotNull(created);
        assertNotNull(created.getId());  // Ensure the ID is auto-generated
        assertEquals(subCategory.getName(), created.getName());
        System.out.println("Created SubCategory: " + created);
    }

    @Test
    @Order(2)
    void read() {
        SubCategory created = subCategoryService.create(subCategory);
        SubCategory read = subCategoryService.read(created.getId());
        assertEquals(created.getId(), read.getId());
        System.out.println("Read SubCategory: " + read.getId());
    }

    @Test
    @Order(3)
    void update() {
        SubCategory created = subCategoryService.create(subCategory);
        SubCategory updated = new SubCategory.Builder()
                .copy(created)
                .setName("Updated Beads")  // Modify the name for testing
                .build();

        SubCategory result = subCategoryService.update(updated);
        assertNotNull(result);
        assertEquals(updated.getName(), result.getName());
        System.out.println("Updated SubCategory: " + result);
    }

    @Test
    @Order(4)
    void delete() {
        SubCategory created = subCategoryService.create(subCategory);
        assertNotNull(created);

        subCategoryService.delete(created.getId());
        SubCategory deleted = subCategoryService.read(created.getId());
        assertNull(deleted.getId());
        System.out.println("Deleted SubCategory ID: " + created.getId());
    }

    @Test
    @Order(5)
    void findAll() {


        List<SubCategory> subCategories = subCategoryService.findAll();
        assertNotNull(subCategories);
        assertTrue(subCategories.size() >= 2);  // Adjust size if more entries exist in DB
        System.out.println("All SubCategories: " + subCategories);
    }

/*    @Test
    @Order(6)
    void findById() {
        SubCategory created = subCategoryService.create(subCategory);
        Optional<SubCategory> found = subCategoryService.read(created.getId());
        assertTrue(found.isPresent());
        assertEquals(created.getId(), found.get().getId());
        System.out.println("Found SubCategory by ID: " + found.get());
    }*/
}
