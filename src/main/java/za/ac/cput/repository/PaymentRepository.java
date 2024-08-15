package za.ac.cput.repository;

/**
 * PaymentRepository.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */


import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long> {
}
