package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Products;
import za.ac.cput.service.IProductService;
import za.ac.cput.service.ProductService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * ProductController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.create(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    // Read a product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products product = productService.read(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable Long id, @RequestBody Products product) {
        Products existingProduct = productService.read(id);
        if (existingProduct != null) {
            //update the fields that can be changed
            Products updatedProduct = new Products.Builder()
                    .copy(existingProduct)
                    .setName(product.getName()) //update fields
                    .setDescription(product.getDescription())
                    .setPrice(product.getPrice())
                    .setStockQuantity(product.getStockQuantity())
                    .setCategoryId(product.getCategoryId())
                    .setCreatedAt(product.getCreatedAt())
                    .setUpdatedAt(product.getUpdatedAt())
                    .setImagePath(product.getImagePath())
                    .build();
            //product.setProductId(id); // Ensure we are updating the correct product
            Products updatedProductResponse = productService.update(updatedProduct);
            return new ResponseEntity<>(updatedProductResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Products existingProduct = productService.read(id);
        if (existingProduct != null) {
            productService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<Products>> getProductsByName(@PathVariable String name) {
        List<Products> products = productService.findByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products by category ID
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Products>> getProductsByCategoryId(@PathVariable long categoryId) {
        List<Products> products = productService.findByCategoryId(categoryId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products by price range
    //works but it's a bit tricky make sure to create two input when developing front end
    @GetMapping("/price")
    public ResponseEntity<List<Products>> getProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Products> products = productService.findByPriceBetween(minPrice, maxPrice);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products by stock quantity greater than
    @GetMapping("/stock")
    public ResponseEntity<List<Products>> getProductsByStockQuantityGreaterThan(@RequestParam int stockQuantity) {
        List<Products> products = productService.findByStockQuantityGreaterThan(stockQuantity);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products created after a certain date
    @GetMapping("/created-after")
    public ResponseEntity<List<Products>> getProductsCreatedAfter(@RequestParam LocalDate createdAt) {
        List<Products> products = productService.findByCreatedAtAfter(createdAt);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Find products updated before a certain date
    @GetMapping("/updated-before")
    public ResponseEntity<List<Products>> getProductsUpdatedBefore(@RequestParam LocalDate updatedAt) {
        List<Products> products = productService.findByUpdatedAtBefore(updatedAt);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}