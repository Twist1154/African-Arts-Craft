package za.ac.cput.factory;

import za.ac.cput.domain.Products;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * ProductFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ProductFactory {

    public static Products buildProduct(long product_id, String name, String description,
                                        double price, int stock_quantity, long category_id,
                                        LocalDate created_at, LocalDate updated_at, String imagePath) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isDoubleNullOrEmpty(price) ||
                Helper.isNullOrEmpty(stock_quantity)
        ) return null;

        return new Products.Builder()
                .setProduct_id(product_id)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock_quantity(stock_quantity)
                .setCategory_id(category_id)
                .setCreated_at(created_at)
                .setUpdated_at(updated_at)
                .setImagePath(imagePath)
                .build();
    }
}
