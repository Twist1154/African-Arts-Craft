package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.domain.Orders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

    @Test
    public void testCreateOrder() {
        // Create test OrderItems with valid data
        OrderItem orderItem1 = OrderItemFactory.buildOrderItem(
                1L,
                12L,
                2,
                12.00,
                null
        );

        OrderItem orderItem2 = OrderItemFactory.buildOrderItem(
                2L,
                5L,
                1,
                10.00,
                null
        );

        OrderItem orderItem3 = OrderItemFactory.buildOrderItem(
                null,
                20L,
                3,
                20.00,
                null
        );

        // Ensure that the OrderItems were created successfully and not null
        assertNotNull(orderItem1);
        assertNotNull(orderItem2);
        assertNotNull(orderItem3);

        // Add OrderItems to a list
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);
        orderItems.add(orderItem3);

        // Creating test data for the Orders object
        Long orderID = 1L;
        Long userID = 1L;
        Long addressID = 1L;
        double totalPrice = 150.0;
        String status = "Pending";
        LocalDate orderDate = LocalDate.now();

        // Build the Orders object
        Orders order = OrderFactory.buildOrder(
                orderID,
                userID,
                addressID,
                status,
                totalPrice,
                orderDate,
                orderItems
        );

        // Asserting that the created order is not null
        assertNotNull(order);

        // Additional assertions to ensure the order details are correct
        assertEquals(orderID, order.getId());
        assertEquals(userID, order.getUserID());
        assertEquals(addressID, order.getAddressID());
        assertEquals(orderDate, order.getOrderDate());
        assertEquals(orderItems, order.getOrderItems());
        assertEquals(totalPrice, order.getTotalPrice());
        assertEquals(status, order.getStatus());

        // Print the created order for debugging
        System.out.println(order);
    }

    @Test
    public void testCreateOrderWithEmptyItems() {
        // Creating test data for the Orders object with no order items
        Long orderID = 2L;
        Long userID = 1L;
        Long addressID = 1L;
        double totalPrice = 0.0; // Assuming 0 for no items
        String status = "Pending";
        LocalDate orderDate = LocalDate.now();

        // Build the Orders object with an empty orderItems list
        List<OrderItem> emptyOrderItems = new ArrayList<>();
        Orders order = OrderFactory.buildOrder(
                orderID,
                userID,
                addressID,
                status,
                totalPrice,
                orderDate,
                emptyOrderItems
        );

        // Asserting that the created order is not null but has no items
        assertNotNull(order);
        assertTrue(order.getOrderItems().isEmpty());
        assertEquals(0.0, order.getTotalPrice());
    }

    @Test
    public void testCreateOrderWithNegativeTotalPrice() {
        // Creating test data for the Orders object with a negative total price
        Long orderID = 3L;
        Long userID = 1L;
        Long addressID = 1L;
        double totalPrice = -50.0;
        String status = "Pending";
        LocalDate orderDate = LocalDate.now();

        // Add empty order items for this test
        List<OrderItem> orderItems = new ArrayList<>();

        // Expecting IllegalArgumentException due to negative total price
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            OrderFactory.buildOrder(
                    orderID,
                    userID,
                    addressID,
                    status,
                    totalPrice,
                    orderDate,
                    orderItems
            );
        });

        assertEquals("Total price must be positive and order must contain at least one item.", thrown.getMessage());
    }
}

//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.domain.Orders;
//import za.ac.cput.domain.Product;
//import za.ac.cput.domain.User;
//import za.ac.cput.factory.ProductFactory;
//import za.ac.cput.factory.OrderFactory;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class OrderFactoryTest {
//
//    @Test
//    void buildOrder_Success() {
//        // Setup test data
//        User user = new User.Builder()
//                .setId(220193894L) // or any relevant ID
//                .setUsername("Sibabalwe")
//                .setPassword("examplePassword") // Add a valid password as per your domain
//                .setEmail("example@mail.com")
//                .setFirstName("Sibabalwe")
//                .setLastName("Ngandana")
//                .setCreatedAt(LocalDate.now()) // Set proper dates
//                .setUpdatedAt(LocalDate.now())
//                .build();
//
//        double totalAmount = 500.00;
//        String status = "CONFIRMED";
//        LocalDate createdAt = LocalDate.now();
//        LocalDate updatedAt = LocalDate.now();
//
//        // Create a product
//        Long productId = 1L;
//        String productName = "African Necklace";
//        String description = "A beautiful handmade African necklace.";
//        double price = 200.00;
//        Set<Product> products = new HashSet<>();
//
//        // Add product to the set
//        Product product = ProductFactory.buildProduct(productId, productName, description, price, new ArrayList<>(), "path/to/image.jpg", null);
//        products.add(product);
//
//        // Build the order
//        Orders order = OrderFactory.buildOrder(user, products, totalAmount, status, createdAt, updatedAt);
//
//        // Assertions to ensure the order is built correctly
//        assertNotNull(order);
//        assertEquals(user, order.getUser());
//        assertEquals(products, order.getProducts());
//        assertEquals(totalAmount, order.getTotalAmount());
//        assertEquals(status, order.getStatus());
//        assertEquals(createdAt, order.getCreatedAt());
//        assertEquals(updatedAt, order.getUpdatedAt());
//    }
//
//    @Test
//    void buildOrder_Failure_MissingUser() {
//        // Test data with missing user
//        double totalAmount = 500.00;
//        String status = "CONFIRMED";
//        LocalDate createdAt = LocalDate.now();
//        LocalDate updatedAt = LocalDate.now();
//
//        Set<Product> products = new HashSet<>();
//        Product product = ProductFactory.buildProduct(1L, "African Necklace", "Handmade", 200.00, new ArrayList<>(), "path/to/image.jpg", null);
//        products.add(product);
//
//        // Build the order with null user
//        Orders order = OrderFactory.buildOrder(null, products, totalAmount, status, createdAt, updatedAt);
//
//        // Expecting null since user is missing
//        assertNull(order);
//    }
//}
