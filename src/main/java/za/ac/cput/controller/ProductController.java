package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import za.ac.cput.domain.Products;
import za.ac.cput.service.ProductService;

import java.io.IOException;

/**
 * ProductController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */


@RestController
@RequestMapping("/store/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Products> addProduct(@RequestParam String name,
                                               @RequestParam String description,
                                               @RequestParam double price,
                                               @RequestParam int stockQuantity,
                                               @RequestParam long categoryId,
                                               @RequestParam MultipartFile image) {
        try {
            Products product = productService.saveProduct(name, description, price, stockQuantity, categoryId, image);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Products> updateProduct(@PathVariable long id,
                                                  @RequestParam String name,
                                                  @RequestParam String description,
                                                  @RequestParam double price,
                                                  @RequestParam int stockQuantity,
                                                  @RequestParam long categoryId,
                                                  @RequestParam(required = false) MultipartFile image) {
        try {
            Products product = productService.updateProduct(id, name, description, price, stockQuantity, categoryId, image);
            return new ResponseEntity<>(product, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
