package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.SubCategory;
import za.ac.cput.service.SubCategoryService;

import java.util.List;

/**
 * SubCategoryController.java
 * <p>
 * This controller handles HTTP requests for managing SubCategory entities.
 * It provides endpoints for creating, reading, updating, deleting, and listing subcategories.
 * <p>
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 25-Aug-24
 */
@RestController
@RequestMapping("/subcategory")
@CrossOrigin(origins = "*")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    /**
     * Endpoint: http://localhost:8080/store/subcategory/create
     * <p>
     * Creates a new subcategory.
     *
     * @param subCategory the subcategory to create
     * @return the created subcategory with HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) {
        System.out.println("Received subcategory: " + subCategory);
        try {
            SubCategory createdSubCategory = subCategoryService.create(subCategory);
            return new ResponseEntity<>(createdSubCategory, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/subcategory/{id}
     * <p>
     * Retrieves a subcategory by its ID.
     *
     * @param id the ID of the subcategory to retrieve
     * @return the found subcategory with HTTP status 200 (OK) or 404 (Not Found) if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long id) {
        try {
            SubCategory subCategory = subCategoryService.read(id);
            if (subCategory != null) {
                return new ResponseEntity<>(subCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/subcategory/update/{id}
     * <p>
     * Updates an existing subcategory.
     *
     * @param id          the ID of the subcategory to update
     * @param subCategory the subcategory data to update
     * @return the updated subcategory with HTTP status 200 (OK),
     * 400 (Bad Request) if IDs mismatch,
     * or 404 (Not Found) if the subcategory does not exist
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable Long id, @RequestBody SubCategory subCategory) {
        if (!id.equals(subCategory.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            SubCategory updatedSubCategory = subCategoryService.update(subCategory);
            if (updatedSubCategory != null) {
                return new ResponseEntity<>(updatedSubCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/subcategory/delete/{id}
     * <p>
     * Deletes a subcategory by its ID.
     *
     * @param id the ID of the subcategory to delete
     * @return HTTP status 204 (No Content) if deletion is successful or 404 (Not Found) if the subcategory does not exist
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
        try {
            boolean isDeleted = subCategoryService.delete(id);
            if (isDeleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/subcategory/getAll
     * <p>
     * Retrieves all subcategories.
     *
     * @return a list of all subcategories with HTTP status 200 (OK)
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        try {
            List<SubCategory> subCategories = subCategoryService.findAll();
            return new ResponseEntity<>(subCategories, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
