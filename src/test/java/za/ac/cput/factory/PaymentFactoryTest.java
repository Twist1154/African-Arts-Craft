package za.ac.cput.factory;

/**
 * PaymentFactoryTest.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Payments;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


class PaymentFactoryTest {

    @Test
    void testBuildPayment() {
        Payments payment = PaymentFactory.buildPayment(
                1L,
                1001L,
                LocalDate.of(2024, 7, 23),
                500.00,
                "Credit Card",
                "Completed"
        );

        assertNotNull(payment);
        assertEquals(1L, payment.getPayment_id());
        assertEquals(1001L, payment.getOrder_id());
        assertEquals(LocalDate.of(2024, 7, 23), payment.getPayment_date());
        assertEquals(500.00, payment.getPayment_amount());
        assertEquals("Credit Card", payment.getPayment_method());
        assertEquals("Completed", payment.getPayment_status());
    }

    @Test
    void testBuildPaymentWithNulls() {
        Payments payment = PaymentFactory.buildPayment(
                1L,
                1001L,
                null,
                0,
                "",
                ""
        );

        assertNull(payment);
    }
}
