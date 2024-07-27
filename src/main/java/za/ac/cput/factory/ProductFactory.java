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

    public static Products buildProduct(long productId, String name, String description,
                                        double price, int stockQuantity, long categoryId,
                                        LocalDate createdAt, LocalDate updatedAt, String imagePath) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isDoubleNullOrEmpty(price) ||
                Helper.isNullOrEmpty(stockQuantity)
        ) return null;

        return new Products.Builder()
                .setProductId(productId)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setCategoryId(categoryId)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .setImagePath(imagePath)
                .build();
    }
}
