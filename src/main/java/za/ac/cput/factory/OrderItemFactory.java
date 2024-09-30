package za.ac.cput.factory;

import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

/**
 * OrderItemFactory.java
 * <p>
 * author Rethabile Ntsekhe
 * Student Num: 220455430
 * date 26-Jul-24
 */

public class OrderItemFactory {
    public static OrderItem buildOrderItem(Long id,
                                           Orders order,
                                           Product product,
                                           int quantity,
                                           double price) {
        if (Helper.isDoubleNullOrEmpty(price) ||
                Helper.isNullOrEmpty(quantity)) {
            return null;
        }

        return new OrderItem.Builder()
                .setId(id)
                .setOrder(order)
                .setProduct(product)
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
