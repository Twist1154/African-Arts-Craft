package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * OrderService.java
 *
 * @author Sibabalwe Ngandana
 * Student Num: 220193894
 * @date 16-Aug-24
 */

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Orders create(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders read(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders update(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Orders> findByUserId(long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Orders> findByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Orders> findOrdersCreatedAfter(LocalDate createdAt) {
        return orderRepository.findOrdersCreatedAfter(createdAt);
    }

    @Override
    public List<Orders> findOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findOrdersByDateRange(startDate, endDate);
    }
}
