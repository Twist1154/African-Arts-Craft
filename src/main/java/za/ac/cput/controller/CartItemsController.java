package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItems;
import za.ac.cput.service.CartItemService;

import java.util.List;
/*
Masithembe Ndzotyana
219145091
CartItemsController Class


 */

@RestController
@RequestMapping("/api/cart-items")
public class CartItemsController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemsController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<CartItems> createCartItem(@RequestBody CartItems cartItem) {
        CartItems createdCartItem = cartItemService.create(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<CartItems> readCartItem(@PathVariable Long id) {
        CartItems cartItem = cartItemService.read(id);
        return cartItem != null ? new ResponseEntity<>(cartItem, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<CartItems> updateCartItem(@RequestBody CartItems cartItem) {
        CartItems updatedCartItem = cartItemService.update(cartItem);
        return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CartItems>> getAllCartItems() {
        List<CartItems> cartItems = cartItemService.findAll();
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItems>> getCartItemsByCartId(@PathVariable long cartId) {
        List<CartItems> cartItems = cartItemService.findByCart_Id(cartId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CartItems>> getCartItemsByProductId(@PathVariable long productId) {
        List<CartItems> cartItems = cartItemService.findByProduct_Id(productId);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}
