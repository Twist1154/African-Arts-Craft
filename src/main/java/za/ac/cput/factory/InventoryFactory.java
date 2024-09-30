package za.ac.cput.factory;


import za.ac.cput.domain.InventoryItem;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * InventoryFactory.java
 *
 * author Rethabile Ntsekhe
 * Student Num: 220455430
 * date 26-Jul-24
 */

public class InventoryFactory {
    public static InventoryItem buildInventory(Long id,
                                               Product product,
                                               int quantity,
                                               String vendorLocation,
                                               LocalDate lastUpdated) {
        if (Helper.isNullOrEmpty(quantity) ||
                Helper.isNullOrEmpty(vendorLocation)
        )
            return null;

        return new InventoryItem.Builder()
                .setId(id)
                .setProduct(product)
                .setQuantity(quantity)
                .setVendorLocation(vendorLocation)
                .setLastUpdated(LocalDate.now())
                .build();
    }
}
