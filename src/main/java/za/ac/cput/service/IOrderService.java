package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;

/**
 * IOrderService.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Service
public interface IOrderService extends IService<Orders, Long> {
    void deleteById(Long orderId);
}
