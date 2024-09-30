package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.SubCategory;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        SubCategory subCategories = new SubCategory();
        SubCategory subCategory = new SubCategory();

        List<SubCategory> subCategoryList = List.of(subCategories, subCategory);

        product = new Product.Builder()
                .setId(1L)
                .setName("African head ")
                .setDescription("This is a test product")
                .setPrice(10.99)
                .setSubCategories(subCategoryList)
                .setImagePath("path/to/image.jpg")
                .build();
    }

    @Test
    void create() {
        Product createdProduct = productService.create(product);
        assertNotNull(createdProduct);
        assertEquals(product.getName(), createdProduct.getName());
    }

    @Test
    void read() {
        Product createdProduct = productService.create(product);
        Product readProduct = productService.read(createdProduct.getId());
        assertNotNull(readProduct);
        assertEquals(createdProduct.getId(), readProduct.getId());
    }

    @Test
    void update() {
        Product createdProduct = productService.create(product);
        createdProduct = new Product.Builder()
                .copy(createdProduct)
                .setName("Updated Test Product")
                .build();
        Product updatedProduct = productService.update(createdProduct);
        assertNotNull(updatedProduct);
        assertEquals("Updated Test Product", updatedProduct.getName());
    }

    @Test
    void findAll() {
        productService.create(product);
        List<Product> products = productService.findAll();
        assertFalse(products.isEmpty());
    }

    @Test
    void findByName() {
        productService.create(product);
        List<Product> products = productService.findByName("African head");
        assertFalse(products.isEmpty());
        assertEquals("African head", products.get(0).getName());
    }

    @Test
    void findByCategoryId() {
        productService.create(product);
        List<Product> products = productService.findByCategoryId(1L);
        assertFalse(products.isEmpty());
        assertEquals(1, products.get(0).getSubCategories().size());
    }

    @Test
    void findByPriceBetween() {
        productService.create(product);
        List<Product> products = productService.findByPriceBetween(10.00, 11.00);
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getPrice() >= 10.00 && products.get(0).getPrice() <= 11.00);
    }



    @Test
    void findByCreatedAtAfter() {
        productService.create(product);
        List<Product> products = productService.findByCreatedAtAfter(LocalDate.now().minusDays(1));
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getCreatedAt().isAfter(LocalDate.now().minusDays(1).atStartOfDay()));
    }

    @Test
    void findByUpdatedAtBefore() {
        productService.create(product);
        List<Product> products = productService.findByUpdatedAtBefore(LocalDate.now().plusDays(1));
        assertFalse(products.isEmpty());
        assertTrue(products.get(0).getUpdatedAt().isBefore(LocalDate.now().plusDays(1).atStartOfDay()));
    }
}
