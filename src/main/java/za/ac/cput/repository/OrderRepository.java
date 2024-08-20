package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.util.List;

/**
 * OrderRepository.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    // Find all orders by a specific user
    @Query("SELECT o FROM Orders o WHERE o.user.user_id = :userId")
    List<Orders> findByUserId(@Param("userId") long userId);

    // Find all orders with a specific status
    @Query("SELECT o FROM Orders o WHERE o.status = :status")
    List<Orders> findByStatus(@Param("status") String status);

    // Find all orders created after a specific date
    @Query("SELECT o FROM Orders o WHERE o.created_at >= :createdAt")
    List<Orders> findOrdersCreatedAfter(@Param("createdAt") LocalDate createdAt);

    // Find all orders within a specific date range
    @Query("SELECT o FROM Orders o WHERE o.order_date BETWEEN :startDate AND :endDate")
    List<Orders> findOrdersByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
