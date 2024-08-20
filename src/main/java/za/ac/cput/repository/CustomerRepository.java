package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;
import java.util.List;

/**
 * CustomerRepository.java
 *
 * @author Sibabalwe Ngandana
 * @date 24-Jul-24
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByEmail(String email);

    @Query(value = "SELECT * FROM customers c WHERE c.created_at >= :createdAt", nativeQuery = true)
    List<Customer> findCustomersCreatedAfter(LocalDate createdAt);
}
