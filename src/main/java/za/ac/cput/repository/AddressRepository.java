package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

import java.util.List;

/**
 * AddressRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByUserId(Long userId);

    List<Address> findAllByUserId(Long userId);

    List<Address> findAllByPostalCode(String postalCode);

    List<Address> findAllByCity(String city);

    List<Address> findAllByProvince(String province);
}
