package za.ac.cput.factory;

import za.ac.cput.domain.Products;
import za.ac.cput.domain.SubCategory;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ProductFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ProductFactory {

    public static Products buildProduct(Long productId, String name, String description,
                                        double price, int stockQuantity, List<SubCategory> subCategory,
                                        LocalDateTime createdAt, LocalDateTime updatedAt, String imagePath) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isDoubleNullOrEmpty(price) ||
                Helper.isNullOrEmpty(stockQuantity)
        ) return null;

        return new Products.Builder()
                .setId(productId)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStockQuantity(stockQuantity)
                .setSubCategories(subCategory)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .setImagePath(imagePath)
                .build();
    }
}
