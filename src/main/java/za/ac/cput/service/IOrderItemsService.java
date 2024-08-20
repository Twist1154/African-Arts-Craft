package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order_Items;

import java.util.List;

/**
 * IOrderItemsService.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Service
public interface IOrderItemsService extends IService<Order_Items, Long> {

    void delete(Long id);

    List<Order_Items> findByOrderId(Long orderId);

    List<Order_Items> findByProductId(Long productId);
}
