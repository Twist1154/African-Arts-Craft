package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import za.ac.cput.domain.Wishlist;
import za.ac.cput.service.WishlistService;

import java.util.List;

/**
 * WishlistController.java
 * <p>
 * This controller handles HTTP requests for managing Wishlist entities.
 * It provides endpoints for creating, reading, updating, deleting, and listing wishlists.
 * <p>
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 25-Aug-24
 */
@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "*")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist/create
     * <p>
     * Creates a new wishlist.
     *
     * @param wishlist the wishlist to create
     * @return the created wishlist with HTTP status 201 (Created)
     */
    @PostMapping("/create")
    public ResponseEntity<Wishlist> createWishlist(@RequestBody Wishlist wishlist) {
        System.out.println("Received wishlist: " + wishlist);
        try {
            Wishlist createdWishlist = wishlistService.create(wishlist);
            return new ResponseEntity<>(createdWishlist, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist/{id}
     * <p>
     * Retrieves a wishlist by its ID.
     *
     * @param id the ID of the wishlist to retrieve
     * @return the found wishlist with HTTP status 200 (OK) or 404 (Not Found) if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<Wishlist> getWishlistById(@PathVariable Long id) {
        try {
            Wishlist wishlist = wishlistService.read(id);
            return new ResponseEntity<>(wishlist, HttpStatus.OK);
        } catch (jakarta.persistence.EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist/update/{id}
     * <p>
     * Updates an existing wishlist.
     *
     * @param id       the ID of the wishlist to update
     * @param wishlist the wishlist data to update
     * @return the updated wishlist with HTTP status 200 (OK), 400 (Bad Request) if IDs mismatch,
     * or 404 (Not Found) if the wishlist does not exist
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Wishlist> updateWishlist(@PathVariable Long id, @RequestBody Wishlist wishlist) {
        if (!id.equals(wishlist.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Wishlist updatedWishlist = wishlistService.update(wishlist);
            return new ResponseEntity<>(updatedWishlist, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist/delete/{id}
     * <p>
     * Deletes a wishlist by its ID.
     *
     * @param id the ID of the wishlist to delete
     * @return HTTP status 204 (No Content) if deletion is successful or 404 (Not Found) if the wishlist does not exist
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWishlist(@PathVariable Long id) {
        try {
            boolean isDeleted = wishlistService.delete(id);
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
     * Endpoint: http://localhost:8080/store/wishlist/getAll
     * <p>
     * Retrieves all wishlists.
     *
     * @return a list of all wishlists with HTTP status 200 (OK)
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<Wishlist>> getAllWishlists() {
        try {
            List<Wishlist> wishlists = wishlistService.findAll();
            return new ResponseEntity<>(wishlists, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Endpoint: http://localhost:8080/store/wishlist/user/{userId}
     * <p>
     * Retrieves all wishlists for a specific user.
     *
     * @param userId the ID of the user
     * @return a list of wishlists for the user with HTTP status 200 (OK) or 404 (Not Found) if user has no wishlists
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Wishlist>> getWishlistsByUserId(@PathVariable Long userId) {
        try {
            List<Wishlist> wishlists = wishlistService.findByUserId(userId);
            if (wishlists.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(wishlists, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
