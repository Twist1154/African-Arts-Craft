package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.WishlistItem;
import za.ac.cput.service.WishlistItemService;

import java.util.List;

/**
 * WishlistItemController.java
 * <p>
 * This controller handles HTTP requests for managing WishlistItem entities.
 * It provides endpoints for creating, reading, updating, deleting, and listing wishlist items.
 * <p>
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 22-Sep-24
 */
@RestController
@RequestMapping("/wishlist-item")
@CrossOrigin(origins = "*")
public class WishlistItemController {

    private final WishlistItemService wishlistItemService;

    @Autowired
    public WishlistItemController(WishlistItemService wishlistItemService) {
        this.wishlistItemService = wishlistItemService;
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/create
     * <p>
     * Creates a new wishlist item.
     *
     * @param wishlistItem the wishlist item to create
     * @return the created wishlist item with HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public ResponseEntity<WishlistItem> createWishlistItem(@RequestBody WishlistItem wishlistItem) {
        System.out.println("Received wishlist item: " + wishlistItem);
        try {
            WishlistItem createdWishlistItem = wishlistItemService.create(wishlistItem);
            return new ResponseEntity<>(createdWishlistItem, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/{id}
     * <p>
     * Retrieves a wishlist item by its ID.
     *
     * @param id the ID of the wishlist item to retrieve
     * @return the found wishlist item with HTTP status 200 (OK) or 404 (Not Found) if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<WishlistItem> getWishlistItemById(@PathVariable Long id) {
        try {
            WishlistItem wishlistItem = wishlistItemService.read(id);
            if (wishlistItem != null) {
                return new ResponseEntity<>(wishlistItem, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/update/{id}
     * <p>
     * Updates an existing wishlist item.
     *
     * @param id           the ID of the wishlist item to update
     * @param wishlistItem the wishlist item data to update
     * @return the updated wishlist item with HTTP status 200 (OK),
     * 400 (Bad Request) if IDs mismatch,
     * or 404 (Not Found) if the wishlist item does not exist
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<WishlistItem> updateWishlistItem(@PathVariable Long id, @RequestBody WishlistItem wishlistItem) {
        if (!id.equals(wishlistItem.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            WishlistItem updatedWishlistItem = wishlistItemService.update(wishlistItem);
            return new ResponseEntity<>(updatedWishlistItem, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/delete/{id}
     * <p>
     * Deletes a wishlist item by its ID.
     *
     * @param id the ID of the wishlist item to delete
     * @return HTTP status 204 (No Content) if deletion is successful or 404 (Not Found) if the wishlist item does not exist
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWishlistItem(@PathVariable Long id) {
        try {
            boolean isDeleted = wishlistItemService.delete(id);
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
     * Endpoint: http://localhost:8080/store/wishlist-item/getAll
     * <p>
     * Retrieves all wishlist items.
     *
     * @return a list of all wishlist items with HTTP status 200 (OK)
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<WishlistItem>> getAllWishlistItems() {
        try {
            List<WishlistItem> wishlistItems = wishlistItemService.findAll();
            return new ResponseEntity<>(wishlistItems, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/wishlist/{wishlistId}
     * <p>
     * Retrieves all wishlist items for a specific wishlist.
     *
     * @param wishlistId the ID of the wishlist
     * @return a list of wishlist items for the specified wishlist with HTTP status 200 (OK) or 404 (Not Found) if none exist
     */
    @GetMapping("/wishlist/{wishlistId}")
    public ResponseEntity<List<WishlistItem>> getWishlistItemsByWishlistId(@PathVariable Long wishlistId) {
        try {
            List<WishlistItem> wishlistItems = wishlistItemService.findByWishlist_Id(wishlistId);
            if (wishlistItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(wishlistItems, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist-item/deleteByWishlist/{wishlistId}
     * <p>
     * Deletes all wishlist items associated with a specific wishlist ID.
     *
     * @param wishlistId the ID of the wishlist whose items are to be deleted
     * @return HTTP status 204 (No Content) if deletion is successful or 404 (Not Found) if the wishlist does not exist
     */
    @DeleteMapping("/deleteByWishlist/{wishlistId}")
    public ResponseEntity<Void> deleteWishlistItemsByWishlistId(@PathVariable Long wishlistId) {
        try {
            wishlistItemService.deleteByWishlistId(wishlistId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
