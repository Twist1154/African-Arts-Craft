package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItems;
import za.ac.cput.repository.CartItemRepository;

import java.util.List;

@Service
public class CartItemService implements ICartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemsRepository) {
        this.cartItemRepository = cartItemsRepository;
    }

    @Override
    public CartItems create(CartItems cartItems) {
        return cartItemRepository.save(cartItems);
    }

    @Override
    public CartItems read(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public CartItems update(CartItems cartItems) {
        CartItems existingProduct = read(cartItems.getId());
        if (existingProduct != null) {
            CartItems updatedProduct = new CartItems.Builder()
                    .copy(cartItems)
                    .setProduct(cartItems.getProduct())
                    .setCart(cartItems.getCart())
                    .setQuantity(cartItems.getQuantity())
                    .build();
            return cartItemRepository.save(updatedProduct);
        }
        throw new IllegalArgumentException("Attempt to update a non-existent cart item with ID: " + cartItems.getId());
    }

    @Override
    public List<CartItems> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItems> findByCart_Id(Long cartId) {
        return cartItemRepository.findByCart_Id(cartId);
    }

    @Override
    public List<CartItems> findByProduct_Id(Long productId) {
        return cartItemRepository.findByProduct_Id(productId);
    }
}
