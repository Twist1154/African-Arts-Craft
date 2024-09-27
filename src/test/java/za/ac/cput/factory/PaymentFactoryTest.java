package za.ac.cput.factory;

/**
 * PaymentFactoryTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFactoryTest {

    @Test
    void testBuildPayment() {
        Orders orders = new Orders();

        Payments payment = PaymentFactory.buildPayment(
                1L,
                orders,
                LocalDate.of(2024, 7, 23),
                500.00,
                "Credit Card",
                "Completed"
        );

        assertNotNull(payment);
        assertEquals(1L, payment.getId());
        assertEquals(1001L, payment.getOrder());
        assertEquals(LocalDate.of(2024, 7, 23), payment.getPayment_date());
        assertEquals(500.00, payment.getPayment_amount());
        assertEquals("Credit Card", payment.getPayment_method());
        assertEquals("Completed", payment.getPayment_status());
    }

    @Test
    void testBuildPaymentWithNulls() {
        Orders orders = new Orders();
        Payments payment = PaymentFactory.buildPayment(
                1L,
                orders,
                null,
                0,
                "",
                ""
        );

        assertNull(payment);
    }
}
