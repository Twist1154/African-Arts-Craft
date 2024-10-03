package za.ac.cput.factory;

import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * PaymentFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class PaymentFactory {

    public static Payments buildPayment(Long id,
                                        Orders order,
                                        User user,
                                        double paymentAmount,
                                        String paymentMethod,
                                        String paymentStatus,
                                        LocalDate paymentDate) {

        if (Helper.isDoubleNullOrEmpty(paymentAmount) ||
                Helper.isNullOrEmpty(paymentMethod) ||
                Helper.isNullOrEmpty(paymentStatus)
        ) return null;

        return new Payments.Builder()
                .setId(id)
                .setUser(user)
                .setOrders(order)
                .setPaymentAmount(paymentAmount)
                .setPaymentMethod(paymentMethod)
                .setPaymentStatus(paymentStatus)
                .setPaymentDate(paymentDate)
                .build();
    }
}
