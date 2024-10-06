package za.ac.cput.service;

/**
 * PaymentServiceTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;
import za.ac.cput.domain.User;
import za.ac.cput.repository.PaymentRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    private Payments payment;

    @BeforeEach
    void setUp() {
        Orders orders = new Orders();
        User user = new User();
        payment = new Payments.Builder()
                .setId(1L)
                .setOrders(orders)
                .setUser(user)
                .setPaymentAmount(500.00)
                .setPaymentMethod("Credit Card")
                .setPaymentStatus("Completed")
                .setPaymentDate(LocalDate.of(2024, 7, 23))
                .build();
    }

    @Test
    void testCreate() {
        Payments created = paymentService.create(payment);
        assertNotNull(created);
        assertEquals(payment.getPaymentAmount(), created.getPaymentAmount());
    }

    @Test
    void testRead() {
        paymentService.create(payment);
        Payments read = paymentService.read(payment.getId());
        assertNotNull(read);
        assertEquals(payment.getId(), read.getId());
    }

    @Test
    void testUpdate() {
        Payments created = paymentService.read(1L);
        Payments update = new Payments.Builder()
                .copy(created)
                .setPaymentAmount(600.00)
                .build();

        Payments updated = paymentService.update(update);
        assertEquals(600.00, updated.getPaymentAmount());
    }

    @Test
    void testDelete() {
        Payments created = paymentService.create(payment);
        paymentService.delete(created.getId());
        Payments deleted = paymentService.read(created.getId());
        assertNull(deleted);
    }

    @Test
    void testFindAll() {
        paymentService.create(payment);
        List<Payments> paymentsList = paymentService.findAll();
        assertFalse(paymentsList.isEmpty());
    }
}
