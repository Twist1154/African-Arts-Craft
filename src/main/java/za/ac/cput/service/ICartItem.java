package za.ac.cput.service;

import za.ac.cput.domain.CartItem;

import java.util.List;

/**
 * ICartItemService.java
 * <p>
 * Interface for CartItem service layer that extends basic CRUD operations from IService.
 * Adds specific methods to find CartItems based on various criteria.
 * <p>
 * Author: Rethabile Ntsekhe
 * Date: 25-Aug-24
 */
public interface ICartItem extends IService<CartItem, Long> {

    /**
     * Finds CartItems by their associated Cart ID.
     *
     * @param cartId the ID of the Cart entity to search by
     * @return a list of CartItems associated with the given Cart ID
     */
    List<CartItem> findByCartId(Long cartId);

    /**
     * Finds CartItems by their associated Product ID.
     *
     * @param productId the ID of the Product entity to search by
     * @return a list of CartItems associated with the given Product ID
     */
    List<CartItem> findByProductId(Long productId);


    /**
     * Finds CartItems by their quantity.
     *
     * @param quantity the quantity of items to search by
     * @return a list of CartItems with the given quantity
     */
    List<CartItem> findByQuantity(int quantity);

    void deleteByCartId(Long cartId);
}
