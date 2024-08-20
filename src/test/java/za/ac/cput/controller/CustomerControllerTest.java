package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.ICustomerService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerControllerTest {

    private final String BASE_URL = "http://localhost:8080/api/customer";
    private static Customer customer1;
    private static Customer customer2;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeAll
    static void setUp() {
        customer1 = CustomerFactory.buildCustomer(
                0L,
                "John",
                "Doe",
                "john.doe@example.com",
                "password123",
                "555-1234",
                LocalDate.of(2024, 7, 24),
                LocalDate.of(2024, 8, 24)
        );

        customer2 = CustomerFactory.buildCustomer(
                0L,
                "Jane",
                "Doe",
                "jane.doe@example.com",
                "password456",
                "555-5678",
                LocalDate.of(2024, 7, 24),
                LocalDate.of(2024, 8, 24)
        );
    }

    @Test
    @Order(1)
    void create() {
        String createURL = BASE_URL + "/create";

        ResponseEntity<Customer> response = restTemplate.postForEntity(createURL, customer1, Customer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        customer1 = response.getBody();  // Capture the ID assigned by the database
        assertNotEquals(0L, customer1.getCustomerId());

        ResponseEntity<Customer> response2 = restTemplate.postForEntity(createURL, customer2, Customer.class);
        assertNotNull(response2);
        assertNotNull(response2.getBody());
        customer2 = response2.getBody();
    }

    @Test
    @Order(2)
    void read() {
        String readURL = BASE_URL + "/read/" + customer1.getCustomerId();
        ResponseEntity<Customer> response = restTemplate.getForEntity(readURL, Customer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(customer1.getCustomerId(), response.getBody().getCustomerId());
    }

    @Test
    @Order(3)
    void update() {
        String updateURL = BASE_URL + "/update";

        Customer updatedCustomer = new Customer.Builder().copy(customer2)
                .setFirstName("Jane Updated")
                .build();

        ResponseEntity<Customer> response = restTemplate.postForEntity(updateURL, updatedCustomer, Customer.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("Jane Updated", response.getBody().getFirstName());
    }

    @Test
    @Order(4)
    void getAll() {
        String getAllURL = BASE_URL + "/getAll";

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getAllURL, HttpMethod.GET, entity, String.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        System.out.println("All Customers: ");
        System.out.println(response.getBody());
    }
}