package za.ac.cput.controller;

/**
 * PaymentControllerTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;
import za.ac.cput.service.PaymentService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@Transactional
class PaymentControllerTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentController paymentController;

    private Payments payment;

    @BeforeEach
    void setUp() {
        Orders orders = new Orders();
        payment = new Payments.Builder()
                .setOrders(orders)
                .setPaymentDate(LocalDate.of(2024, 7, 23))
                .setPaymentAmount(500.00)
                .setPaymentMethod("Credit Card")
                .setPaymentStatus("Completed")
                .build();
    }

    @Test
    void testCreatePayment() {
        ResponseEntity<Payments> response = paymentController.createPayment(payment);
        assertEquals(200, response.getStatusCodeValue());
        Payments createdPayment = response.getBody();
        assertNotNull(createdPayment);
        assertEquals(payment.getPaymentAmount(), createdPayment.getPaymentAmount());
    }

    @Test
    void testReadPayment() {
        Payments createdPayment = paymentService.create(payment);
        ResponseEntity<Payments> response = paymentController.readPayment(createdPayment.getId());
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(createdPayment.getId(), response.getBody().getId());
    }

    @Test
    void testUpdatePayment() {
        Payments createdPayment = paymentService.create(payment);

        Payments updated = new Payments.Builder()
                .copy(createdPayment)
                .setPaymentAmount(600.00)
                .build();


        ResponseEntity<Payments> response = paymentController.updatePayment(updated);
        assertEquals(200, response.getStatusCodeValue());
        Payments updatedPayment = response.getBody();
        assertNotNull(updatedPayment);
        assertEquals(600.00, updatedPayment.getPaymentAmount());
    }

    @Test
    void testDeletePayment() {
        Payments createdPayment = paymentService.create(payment);
        ResponseEntity<Void> response = paymentController.deletePayment(createdPayment.getId());
        assertEquals(204, response.getStatusCodeValue());

        // Confirm deletion
        Payments deletedPayment = paymentService.read(createdPayment.getId());
        assertNull(deletedPayment);
    }

    @Test
    void testGetAllPayments() {
        paymentService.create(payment);
        ResponseEntity<List<Payments>> response = paymentController.getAllPayments();
        assertEquals(200, response.getStatusCodeValue());
        assertFalse(response.getBody().isEmpty());
    }
}
