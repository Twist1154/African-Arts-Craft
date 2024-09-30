package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class CustomerFactory {

    public static Customer buildCustomer(long customerId, String firstName, String lastName, String email, String password, String phoneNumber, LocalDate createdAt, LocalDate updatedAt) {

        if (Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(phoneNumber)) {
            return null;
        }

        String emailRegex = "^(.+)@(\\S+)$";
        if (!Helper.isEmailValid(email, emailRegex)) {
            return null;
        }

        return new Customer.Builder()
                .setId(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setPhoneNumber(phoneNumber)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
    }
}
