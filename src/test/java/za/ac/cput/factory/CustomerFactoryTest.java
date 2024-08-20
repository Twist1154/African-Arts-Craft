package za.ac.cput.factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void buildCustomer_Success() {
        long customerId = 1;
        String firstName = "Sibabalwe";
        String lastName = "Ngandana";
        String email = "siba@gmail.com";
        String password = "password123";
        String phoneNumber = "+27-555-1234";
        LocalDate createdAt = LocalDate.of(2024, 7, 24);
        LocalDate updatedAt = LocalDate.of(2024, 8, 24);

        Customer customer = CustomerFactory.buildCustomer(customerId, firstName, lastName, email, password, phoneNumber, createdAt, updatedAt);

        assertNotNull(customer);
        assertEquals(firstName, customer.getFirstName());
        assertEquals(lastName, customer.getLastName());
        assertEquals(email, customer.getEmail());
        assertEquals(password, customer.getPassword());
        assertEquals(phoneNumber, customer.getPhoneNumber());
        assertEquals(createdAt, customer.getCreatedAt());
        assertEquals(updatedAt, customer.getUpdatedAt());
    }

    @Test
    void buildCustomer_Failure_NullFields() {
        long customerId = 1;
        String firstName = null; // Null first name
        String lastName = "Ngandana";
        String email = "siba@gmail.com";
        String password = "password123";
        String phoneNumber = "+27-555-1234";
        LocalDate createdAt = LocalDate.of(2024, 7, 24);
        LocalDate updatedAt = LocalDate.of(2024, 8, 24);

        Customer customer = CustomerFactory.buildCustomer(customerId, firstName, lastName, email, password, phoneNumber, createdAt, updatedAt);

        assertNull(customer);
    }

    @Test
    void buildCustomer_Failure_InvalidEmail() {
        long customerId = 1;
        String firstName = "Sibabalwe";
        String lastName = "Ngandana";
        String email = "sibagmail.com"; // Invalid email
        String password = "password123";
        String phoneNumber = "+27-555-1234";
        LocalDate createdAt = LocalDate.of(2024, 7, 24);
        LocalDate updatedAt = LocalDate.of(2024, 8, 24);

        Customer customer = CustomerFactory.buildCustomer(customerId, firstName, lastName, email, password, phoneNumber, createdAt, updatedAt);

        assertNull(customer);
    }
}