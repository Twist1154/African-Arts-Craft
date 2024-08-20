package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order_Items;
import za.ac.cput.repository.OrderItemsRepository;

import java.util.List;

/**
 * OrderItemsService.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Service
public class OrderItemsService implements IOrderItemsService {

    private final OrderItemsRepository orderItemsRepository;

    @Autowired
    public OrderItemsService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }

    @Override
    public Order_Items create(Order_Items orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Override
    public Order_Items read(Long id) {
        return orderItemsRepository.findById(id).orElse(null);
    }

    @Override
    public Order_Items update(Order_Items orderItems) {
        return orderItemsRepository.save(orderItems);
    }

    @Override
    public void delete(Long id) {
        orderItemsRepository.deleteById(id);
    }

    @Override
    public List<Order_Items> findAll() {
        return orderItemsRepository.findAll();
    }

    @Override
    public List<Order_Items> findByOrderId(Long orderId) {
        return orderItemsRepository.findByOrderId(orderId);
    }

    @Override
    public List<Order_Items> findByProductId(Long productId) {
        return orderItemsRepository.findByProductId(productId);
    }
}
