package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * AddressFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class AddressFactory {
    public static Address buildAddress(Long id,
                                       User user,
                                       String address_line1,
                                       String addressLine2,
                                       String city,
                                       String province,
                                       String postal_code,
                                       String country,
                                       LocalDate created_at,
                                       LocalDate updated_at) {
        if (Helper.isNullOrEmpty(address_line1) ||
                Helper.isNullOrEmpty(city) ||
                Helper.isNullOrEmpty(province) ||
                Helper.isNullOrEmpty(postal_code) ||
                Helper.isNullOrEmpty(country)
        ) return null;

        return new Address.Builder()
                .setId(id)
                .setUser(user)
                .setAddressLine1(address_line1)
                .setAddressLine2(addressLine2)
                .setCity(city)
                .setProvince(province)
                .setPostalCode(postal_code)
                .setCountry(country)
                .setCreatedAt(created_at)
                .setUpdatedAt(updated_at)
                .build();
    }
}
