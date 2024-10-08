package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.OrderItem;

import java.util.List;

/**
 * OrderItemsRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {
    @Override
    void deleteById(Long id);


    List<OrderItem> findByOrder_Id(Long orderId);

    void deleteByOrder_Id(Long orderId);
}