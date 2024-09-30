package za.ac.cput.factory;

import za.ac.cput.domain.ShippingMethods;
import za.ac.cput.util.Helper;

/**
 * ShippingMethodFactory.java
 *
 * author Rethabile Ntsekhe
 * Student Num: 220455430
 * date 26-Jul-24
 */

public class ShippingMethodFactory {
    public static ShippingMethods buildShippingMethod(Long id,
                                                      String name,
                                                      String description,
                                                      double cost,
                                                      String delivery_time) {
        if (Helper.isNullOrEmpty(name) ||
                Helper.isDoubleNullOrEmpty(cost) ||
                Helper.isNullOrEmpty(delivery_time)
        ) return null;

        return new ShippingMethods.Builder()
                .setId(id)
                .setName(name)
                .setDescription(description)
                .setCost(cost)
                .setDeliveryTime(delivery_time)
                .build();
    }
}
