package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Orders;

/**
 * OrderRepository.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    void deleteById(Long id);
}
