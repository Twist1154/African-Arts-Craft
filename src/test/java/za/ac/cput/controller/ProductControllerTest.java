package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.SubCategory;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Product product;

    @BeforeEach
    void setUp() {
        SubCategory subCategory = new SubCategory();

        product = new Product.Builder()
                .setId(28L)
                .setName("African head")
                .setDescription("This is a test product")
                .setPrice(10.99)
                .setSubCategories((List<SubCategory>) subCategory)
                .setImagePath("path/to/image.jpg")
                .build();
    }

    @Test
    void createProduct() {
        ResponseEntity<Product> response = restTemplate.postForEntity("/store/api/products", product, Product.class);
        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody().getName());
    }

    @Test
    void getProductById() {
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getId(), Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(createdProduct.getId(), response.getBody().getId());
    }

    @Test
    void updateProduct() {
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        createdProduct = new Product.Builder().copy(createdProduct).setName("Updated Product").build();
        HttpEntity<Product> requestUpdate = new HttpEntity<>(createdProduct);
        ResponseEntity<Product> response = restTemplate.exchange("/store/api/products", HttpMethod.PUT, requestUpdate, Product.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Updated Product", response.getBody().getName());
    }

    @Test
    void deleteProduct() {
        Product createdProduct = restTemplate.postForObject("/store/api/products", product, Product.class);
        restTemplate.delete("/store/api/products/" + createdProduct.getId());
        ResponseEntity<Product> response = restTemplate.getForEntity("/store/api/products/" + createdProduct.getId(), Product.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getAllProducts() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products", Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().length > 0);
    }

    @Test
    void getProductsByName() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/name/" + product.getName(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getName(), response.getBody()[0].getName());
    }

    @Test
    void getProductsByCategoryId() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/category/" + product.getSubCategories(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(product.getSubCategories(), response.getBody()[0].getSubCategories());
    }

    @Test
    void getProductsByPriceRange() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/price-range?minPrice=10.00&maxPrice=11.00", Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getPrice() >= 10.00 && response.getBody()[0].getPrice() <= 11.00);
    }



    @Test
    void getProductsCreatedAfter() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/created-after?createdAt=" + LocalDate.now().minusDays(1), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getCreatedAt().isAfter(LocalDate.now().minusDays(1).atStartOfDay()));
    }

    @Test
    void getProductsUpdatedBefore() {
        restTemplate.postForObject("/store/api/products", product, Product.class);
        ResponseEntity<Product[]> response = restTemplate.getForEntity("/store/api/products/updated-before?updatedAt=" + LocalDate.now(), Product[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody()[0].getUpdatedAt().isBefore(ChronoLocalDateTime.from(LocalDate.now().plusDays(1))));
    }
}
