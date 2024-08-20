package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.ICustomerService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private ICustomerService customerService;

    private static Customer customer1;
    private static Customer customer2;

    @BeforeAll
    static void setUp() {
        customer1 = CustomerFactory.buildCustomer(
                0L,
                "Sibabalwe",
                "Ngandana",
                "siba@gmail.com",
                "password123",
                "+27-555-1234",
                LocalDate.of(2024, 7, 24),
                LocalDate.of(2024, 8, 24)
        );

        customer2 = CustomerFactory.buildCustomer(
                0L,
                "Sibabalwe",
                "Ngandana",
                "siba@gmail.com",
                "password456",
                "+27-555-1234",
                LocalDate.of(2024, 7, 24),
                LocalDate.of(2024, 8, 24)
        );
    }

    @Test
    @Order(1)
    void create() {
        Customer savedCustomer1 = customerService.create(customer1);
        assertNotNull(savedCustomer1);
        assertNotEquals(0L, savedCustomer1.getCustomerId()); // Ensure ID is auto-generated
        System.out.println(savedCustomer1);

        Customer savedCustomer2 = customerService.create(customer2);
        assertNotNull(savedCustomer2);
    }

    @Test
    @Order(2)
    void read() {
        Customer readCustomer = customerService.read(customer1.getCustomerId());
        assertNotNull(readCustomer);
        assertEquals(customer1.getCustomerId(), readCustomer.getCustomerId());
    }

    /*
        @Test
        @Order(3)
        void update() {
            customer1.setFirstName("Johnny");
            Customer updatedCustomer = customerService.update(customer1);
            assertNotNull(updatedCustomer);
            assertEquals("Johnny", updatedCustomer.getFirstName());
        }
    */
    @Test
    @Order(4)
    void delete() {
        customerService.delete(customer1.getCustomerId());
        Customer deletedCustomer = customerService.read(customer1.getCustomerId());
        assertNull(deletedCustomer);
    }

    @Test
    @Order(5)
    void findAll() {
        assertNotNull(customerService.findAll());
        assertTrue(customerService.findAll().size() > 0);
    }
}
