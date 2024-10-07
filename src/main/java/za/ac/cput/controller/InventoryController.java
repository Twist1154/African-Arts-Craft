package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.InventoryItem;
import za.ac.cput.service.InventoryServiceImply;

import java.util.List;

/**
 * InventoryController.java
 * <p>
 * This class serves as the REST Controller for managing Inventory operations.
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 06-Oct-24
 */
@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {

    @Autowired
    private InventoryServiceImply inventoryService;

    /**
     * Create a new inventory item.
     *
     * @param inventoryItem the item to create.
     * @return ResponseEntity with the created item and HTTP status.
     */
    @PostMapping("/create")
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem inventoryItem) {
        System.out.println("Received inventory item: " + inventoryItem);
        InventoryItem createdItem = inventoryService.create(inventoryItem);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    /**
     * Read an inventory item by its ID.
     *
     * @param id the ID of the inventory item.
     * @return ResponseEntity with the found item or HTTP NOT FOUND status.
     */
    @GetMapping("/read/{id}")
    public ResponseEntity<InventoryItem> read(@PathVariable Long id) {
        InventoryItem item = inventoryService.read(id);
        if (item != null)
            return new ResponseEntity<>(item, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Update an existing inventory item.
     *
     * @param inventoryItem the item to update.
     * @return ResponseEntity with the updated item and HTTP status.
     */
    @PutMapping("/update")
    public ResponseEntity<InventoryItem> update(@RequestBody InventoryItem inventoryItem) {
        InventoryItem updatedItem = inventoryService.update(inventoryItem);
        if (updatedItem != null)
            return new ResponseEntity<>(updatedItem, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete an inventory item by its ID.
     *
     * @param id the ID of the inventory item.
     * @return ResponseEntity with HTTP NO CONTENT if deleted.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        inventoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Retrieve all inventory items.
     *
     * @return ResponseEntity with a list of inventory items and HTTP status.
     */
    @GetMapping("/all")
    public ResponseEntity<List<InventoryItem>> findAll() {
        List<InventoryItem> items = inventoryService.findAll();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    /**
     * Retrieve all inventory items by product ID.
     *
     * @param productId the ID of the product.
     * @return ResponseEntity with a list of inventory items and HTTP status.
     */
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<InventoryItem>> findByProduct_Id(@PathVariable Long productId) {
        List<InventoryItem> items = inventoryService.findByProduct_Id(productId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
