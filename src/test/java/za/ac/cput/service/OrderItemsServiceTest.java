package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.Order_Items;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.OrderItemsRepository;
import za.ac.cput.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderItemsServiceTest {

    @Autowired
    private OrderItemsService orderItemsService;

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    @Autowired
    private OrderRepository orderRepository;

    private Orders order;
    private Order_Items orderItem;

    @BeforeEach
    void setUp() {
        orderRepository.deleteAll();
        orderItemsRepository.deleteAll();

        // Create an order
        order = new Orders.Builder()
                .setUser(null) // Use appropriate user object if needed
                .setTotal_amount(150.00)
                .setOrder_date(LocalDate.now())
                .setStatus("Pending")
                .setShipping_address("123 Main St")
                .setBilling_address("456 Oak St")
                .setPayment_method("Credit Card")
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .build();
        orderRepository.save(order); // Save order to the repository

        // Create an order item
        orderItem = new Order_Items.Builder()
                .setOrder(order) // Use the order object
                .setProduct(null) // Set a valid product object if available
                .setQuantity(10) // Set quantity
                .setPrice(15.00) // Set price
                .build();
    }

    @Test
    void testCreate() {
        Order_Items createdOrderItem = orderItemsService.create(orderItem);
        assertNotNull(createdOrderItem);
        assertEquals(orderItem.getQuantity(), createdOrderItem.getQuantity());
    }

    @Test
    void testRead() {
        Order_Items createdOrderItem = orderItemsService.create(orderItem);
        Order_Items foundOrderItem = orderItemsService.read(createdOrderItem.getOrder_item_id());
        assertNotNull(foundOrderItem);
        assertEquals(orderItem.getQuantity(), foundOrderItem.getQuantity());
    }

    @Test
    void testUpdate() {
        Order_Items createdOrderItem = orderItemsService.create(orderItem);
        Order_Items updatedOrderItem = new Order_Items.Builder()
                .copy(createdOrderItem)
                .setQuantity(20) // Update quantity
                .build();
        Order_Items result = orderItemsService.update(updatedOrderItem);
        assertNotNull(result);
        assertEquals(20, result.getQuantity());
    }

    @Test
    void testDelete() {
        Order_Items createdOrderItem = orderItemsService.create(orderItem);
        orderItemsService.delete(createdOrderItem.getOrder_item_id());
        Order_Items foundOrderItem = orderItemsService.read(createdOrderItem.getOrder_item_id());
        assertNull(foundOrderItem);
    }

    @Test
    void testFindAll() {
        orderItemsService.create(orderItem);
        List<Order_Items> orderItems = orderItemsService.findAll();
        assertFalse(orderItems.isEmpty());
    }
}
