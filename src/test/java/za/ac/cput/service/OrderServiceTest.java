package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Users;
import za.ac.cput.repository.OrderRepository;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderServiceTest {

    @Autowired
    private OrderService ordersService; // corrected this line it was OrdersService instead of OrderService

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    private Users user;
    private Orders order;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        orderRepository.deleteAll();

        // Create a user
        user = new Users.Builder()
                .setUser_id(1L) // Assuming you have a setUser_id method
                .setUsername("Twist11577")
                .setPassword("password")
                .setEmail("rethabile@gmail.com")
                .setFirst_name("Rethabile")
                .setLast_name("Ntsekhe")
                .setCreated_at(LocalDate.of(2024, 7, 24))
                .setUpdated_at(LocalDate.of(2024, 8, 24))
                .build();
        userRepository.save(user); // Save user to the repository

        // Create an order
        order = new Orders.Builder()
                .setUser(user) // Use the user object
                .setTotal_amount(150.00)
                .setOrder_date(LocalDate.of(2024, 8, 19))
                .setStatus("Pending")
                .setShipping_address("123 Main St")
                .setBilling_address("456 Oak St")
                .setPayment_method("Credit Card")
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .build();
    }

    @Test
    void testCreate() {
        Orders createdOrder = ordersService.create(order);
        assertNotNull(createdOrder);
        assertEquals(order.getUser().getUsername(), createdOrder.getUser().getUsername());
    }

    @Test
    void testRead() {
        Orders createdOrder = ordersService.create(order);
        Orders foundOrder = ordersService.read(createdOrder.getOrder_id()); // Pass Long directly
        assertNotNull(foundOrder);
        assertEquals(order.getTotal_amount(), foundOrder.getTotal_amount());
    }


    @Test
    void testUpdate() {
        Orders createdOrder = ordersService.create(order);
        Orders updatedOrder = new Orders.Builder()
                .copy(createdOrder)
                .setStatus("Shipped")
                .build();
        Orders result = ordersService.update(updatedOrder);
        assertNotNull(result);
        assertEquals("Shipped", result.getStatus());
    }

    @Test
    void testDelete() {
        Orders createdOrder = ordersService.create(order);
        ordersService.delete(createdOrder.getOrder_id()); // Pass Long directly
        Orders foundOrder = ordersService.read(createdOrder.getOrder_id());
        assertNull(foundOrder);
    }


    @Test
    void testFindAll() {
        ordersService.create(order);
        List<Orders> orders = ordersService.findAll();
        assertFalse(orders.isEmpty());
    }
}
