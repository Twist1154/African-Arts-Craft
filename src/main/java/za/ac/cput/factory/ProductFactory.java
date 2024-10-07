package za.ac.cput.factory;

import za.ac.cput.domain.InventoryItem;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.SubCategory;
import za.ac.cput.util.Helper;

import java.util.List;

/**
 * ProductFactory.java
 * <p>
 * author Rethabile Ntsekhe
 * Student Num: 220455430
 * date 26-Jul-24
 */

public class ProductFactory {

    public static Product buildProduct(Long id,
                                       String name,
                                       String description,
                                       double price,
                                       List<SubCategory> subCategory,
                                       String imagePath,
                                       InventoryItem inventoryItem
    ) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(description) ||
                Helper.isDoubleNullOrEmpty(price)
        ) return null;

        return new Product.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setSubCategories(subCategory)
                .setImagePath(imagePath)
                .setInventoryItem(inventoryItem)
                .build();
    }
}
