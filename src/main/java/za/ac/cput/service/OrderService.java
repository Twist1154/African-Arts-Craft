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
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 06-Oct-24
 */
@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;


    @Override
    public Orders create(Orders orders) {
        return orderRepository.save(orders);
    }


    @Override
    public Orders read(Long id) {
        return orderRepository.findById(id).orElse(null);
    }


    @Override
    public Orders update(Orders orders) {
        Orders existingOrder = orderRepository.findById(orders.getId()).orElse(null);
        if (existingOrder != null) {
            Orders updatedOrder = new Orders.Builder()
                    .copy(existingOrder)
                    .setId(existingOrder.getId())
                    .setUser(existingOrder.getUser())
                    .setTotalAmount(orders.getTotalAmount())
                    .setStatus(orders.getStatus())
                    .setAddress(orders.getAddress())
                    .setPayment(orders.getPayment())
                    .build();
            return orderRepository.save(orders);
        }
        return null;
    }


    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Long orderId) {
        orderItemService.deleteById(orderId);
        orderRepository.deleteById(orderId);

    }
}
