package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Cart;
import za.ac.cput.repository.CartRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CartService implements ICartService {

    private final CartRepository cartRepository;
    private final CartItemService cartItemService;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
    }

    @Override
    public Cart create(Cart cart) {
        Cart savedCart = cartRepository.save(cart);
        log.info("Cart created: {}", savedCart);
        return savedCart;
    }

    @Override
    public Cart read(Long id) {
        return cartRepository.findById(id).orElse(null); // Consider returning Optional<Cart>
    }

    @Override
    public Cart update(Cart cartDetails) {
        Cart existingCart = read(cartDetails.getId());

        if (existingCart != null) {
            Cart updatedCart = new Cart.Builder()
                    .copy(cartDetails)
                    .setId(existingCart.getId()) // This might not be needed since cartDetails already has the ID
                    .setUser(cartDetails.getUser())
                    .setTotal(cartDetails.getTotal())
                    .build();
            Cart savedCart = cartRepository.save(updatedCart);
            log.info("Cart updated: {}", savedCart);
            return savedCart;
        }

        log.error("Attempted to update a non-existent Cart with ID: {}", cartDetails.getId());
        return null;
    }

    @Override
    public void deleteById(Long id) {
        cartItemService.delete(id); // Ensure this is necessary
        cartRepository.deleteById(id);
        log.info("Cart deleted with ID: {}", id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> findByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public List<Cart> findByCreatedAtAfter(LocalDateTime createdAt) {
        return cartRepository.findByCreatedAtAfter(createdAt);
    }

    @Override
    public List<Cart> findByTotalGreaterThan(Double total) {
        return cartRepository.findByTotalGreaterThan(total);
    }

    @Override
    public List<Cart> findByUpdatedAtAfter(LocalDateTime updatedAt) {
        return cartRepository.findByUpdatedAtAfter(updatedAt);
    }

    @Override
    public List<Cart> findCartsCreatedWithinDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return cartRepository.findCartsCreatedWithinDateRange(startDate, endDate);
    }

    @Override
    public Cart findCartWithHighestTotal() {
        return cartRepository.findCartWithHighestTotal();
    }

    @Override
    public List<Cart> findCartsWithTotalGreaterThan(Double total) {
        return cartRepository.findCartsWithTotalGreaterThan(total);
    }

    @Override
    public List<Cart> findByUserIdAndCreatedAtAfter(Long userId, LocalDateTime createdAt) {
        return cartRepository.findByUserIdAndCreatedAtAfter(userId, createdAt);
    }

    @Override
    public List<Cart> findByUserIdAndUpdatedAtAfter(Long userId, LocalDateTime updatedAt) {
        return cartRepository.findByUserIdAndUpdatedAtAfter(userId, updatedAt);
    }

    @Override
    public List<Cart> findByCreatedAtBefore(LocalDateTime createdAt) {
        return cartRepository.findByCreatedAtBefore(createdAt);
    }

    @Override
    public List<Cart> findByUpdatedAtBefore(LocalDateTime updatedAt) {
        return cartRepository.findByUpdatedAtBefore(updatedAt);
    }

    @Override
    public List<Cart> findCartsCreatedInLast30Days() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return cartRepository.findByCreatedAtAfter(thirtyDaysAgo);
    }


    @Override
    public void deleteByUserId(Long userId) { // More descriptive method name
        List<Cart> userCarts = cartRepository.findByUserId(userId);
        for (Cart cart : userCarts) {
            cartRepository.delete(cart);
            log.info("Deleted cart with ID: {}", cart.getId());
        }
    }
}
