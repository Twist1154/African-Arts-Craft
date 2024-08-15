package za.ac.cput.controller;

/**
 * PaymentControllerTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Payments;
import za.ac.cput.service.PaymentService;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PaymentControllerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentController paymentController;

    private Payments payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        payment = new Payments.Builder()
                .setPayment_id(1L)
                .setOrder_id(1001L)
                .setPayment_date(LocalDate.of(2024, 7, 23))
                .setPayment_amount(500.00)
                .setPayment_method("Credit Card")
                .setPayment_status("Completed")
                .build();
    }

    @Test
    void testCreatePayment() {
        when(paymentService.create(payment)).thenReturn(payment);
        ResponseEntity<Payments> response = paymentController.createPayment(payment);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(payment, response.getBody());
    }

    @Test
    void testReadPayment() {
        when(paymentService.read(1L)).thenReturn(Optional.of(payment));
        ResponseEntity<Payments> response = paymentController.readPayment(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(payment, response.getBody());
    }

    @Test
    void testUpdatePayment() {
        when(paymentService.update(payment)).thenReturn(payment);
        ResponseEntity<Payments> response = paymentController.updatePayment(payment);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(payment, response.getBody());
    }

    @Test
    void testDeletePayment() {
        doNothing().when(paymentService).delete(1L);
        ResponseEntity<Void> response = paymentController.deletePayment(1L);
        assertEquals(204, response.getStatusCodeValue());
        verify(paymentService, times(1)).delete(1L);
    }

    @Test
    void testGetAllPayments() {
        // Test code for getAllPayments() can be added here.
    }
}
