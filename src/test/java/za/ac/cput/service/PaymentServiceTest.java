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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;
import za.ac.cput.repository.PaymentRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    private Payments payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Orders orders = new Orders();
        payment = new Payments.Builder()
                .setId(1L)
                .setOrders(orders)
                .setPayment_date(LocalDate.of(2024, 7, 23))
                .setPayment_amount(500.00)
                .setPayment_method("Credit Card")
                .setPayment_status("Completed")
                .build();
    }

    @Test
    void testCreate() {
        when(paymentRepository.save(payment)).thenReturn(payment);
        Payments created = paymentService.create(payment);
        assertEquals(payment, created);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testRead() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.of(payment));
        Optional<Payments> read = paymentService.read(1L);
        assertTrue(read.isPresent());
        assertEquals(payment, read.get());
    }

    @Test
    void testUpdate() {
        when(paymentRepository.save(payment)).thenReturn(payment);
        Payments updated = paymentService.update(payment);
        assertEquals(payment, updated);
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testDelete() {
        doNothing().when(paymentRepository).deleteById(1L);
        paymentService.delete(1L);
        verify(paymentRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindAll() {
        // Test code for findAll() can be added here.
    }
}
