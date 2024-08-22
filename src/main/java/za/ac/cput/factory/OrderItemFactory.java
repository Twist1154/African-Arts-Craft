package za.ac.cput.factory;

import za.ac.cput.domain.Order_Items;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Products;
import za.ac.cput.util.Helper;

/**
 * OrderItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class OrderItemFactory {
    public static Order_Items buildOrderItem(Long orderItemId, Orders order, Products product, int quantity, double price) {
        if (Helper.isDoubleNullOrEmpty(price) || Helper.isNullOrEmpty(quantity)) {
            return null;
        }

        return new Order_Items.Builder()
                .setOrderItemId(orderItemId)
                .setOrder(order)  // Pass the entire Orders object
                .setProduct(product)  // Pass the entire Products object
                .setQuantity(quantity)
                .setPrice(price)
                .build();
    }
}
