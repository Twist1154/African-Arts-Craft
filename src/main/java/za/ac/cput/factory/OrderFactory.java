package za.ac.cput.factory;

import za.ac.cput.domain.Address;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.Payments;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

/**
 * OrderFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class OrderFactory {

    public static Orders buildOrder(User user,
                                    double totalAmount,
                                    String status,
                                    Address address,
                                    Payments payment
    ) {
        if (Helper.isDoubleNullOrEmpty(totalAmount) ||
                Helper.isNullOrEmpty(status) ||
                Helper.isNullOrEmpty(address) ||
                Helper.isNullOrEmpty(payment)) {
            return null;
        }

        return new Orders.Builder()
                .setUser(user)
                .setTotalAmount(totalAmount)
                .setStatus(status)
                .setAddress(address)
                .setPayment(payment)
                .build();
    }
}
