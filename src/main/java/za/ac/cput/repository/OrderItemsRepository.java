package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Order_Items;

import java.util.List;

/**
 * OrderItemsRepository.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Repository
public interface OrderItemsRepository extends JpaRepository<Order_Items, Long> {

    // Find all order items by a specific order ID
    @Query("SELECT oi FROM Order_Items oi WHERE oi.order.order_id = :orderId")
    List<Order_Items> findByOrderId(@Param("orderId") long orderId);

    // Find all order items by a specific product ID
    @Query("SELECT oi FROM Order_Items oi WHERE oi.product_id = :productId")
    List<Order_Items> findByProductId(@Param("productId") long productId);
}
