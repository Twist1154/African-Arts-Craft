package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.util.List;

/**
 * IOrderService.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Service
public interface IOrderService extends IService<Orders, Long> {

    void delete(Long id);

    List<Orders> findByUserId(long userId);

    List<Orders> findByStatus(String status);

    List<Orders> findOrdersCreatedAfter(LocalDate createdAt);

    List<Orders> findOrdersByDateRange(LocalDate startDate, LocalDate endDate);
}
