package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.service.CategoryService;

import java.util.List;

/**
 * CategoriesController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 30-Jul-24
 */

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
// Allow CORS for this controller this is optional allows requests from port 3000
public class CategoriesController {
    private final CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Endpoint: http://localhost:8080/store/categories/create
     */
    @PostMapping("/create")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category createdCategory = categoryService.create(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    /**
     * Endpoint: http://localhost:8080/store/categories/get/{id}
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.read(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/categories/update
     */
    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category updatedCategory = categoryService.update(category);
        if (updatedCategory != null) {
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/categories/getAll
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
