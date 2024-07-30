package za.ac.cput.service;

import za.ac.cput.domain.Addresses;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * IAddressService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */

public interface IAddressService extends IService<Addresses, Long> {

    Optional<Addresses> findByUser(Addresses user_id);

    // Find addresses by city
    List<Addresses> findByCity(String city);

    // Find addresses by postal code
    List<Addresses> findByPostal_code(String postalCode);

    // Find addresses created after a specific date
    List<Addresses> findByCreated_atAfter(LocalDate date);

    // Custom query example: Find addresses by province
    List<Addresses> findAddressesByProvince(String province);
}
