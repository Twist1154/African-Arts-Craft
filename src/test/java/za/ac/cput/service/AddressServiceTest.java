package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.User;
import za.ac.cput.repository.AddressRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
class AddressServiceTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    private Address address;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User.Builder()
                .setId(56)
                .setUsername("testuser")
                .setPassword("password")
                .setEmail("test@example.com")
                .setFirstName("Test")
                .setLastName("User")
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .build();

        address = new Address.Builder()
                .setId(1L)
                .setUser(user)
                .setAddressLine1("123 Test St")
                .setAddressLine2("Apt 4B")
                .setCity("Test City")
                .setProvince("Test Province")
                .setPostalCode("12345")
                .setCountry("Test Country")
                .setCreatedAt(LocalDate.now())
                .setUpdatedAt(LocalDate.now())
                .build();
    }

    @Test
    void create() {
        Address createdAddress = addressService.create(address);
        System.out.println(createdAddress);
        assertNotNull(createdAddress);
        assertEquals(address.getId(), createdAddress.getId());
        assertEquals(address.getAddressLine1(), createdAddress.getAddressLine1());
    }

    @Test
    void read() {
        addressService.create(address);  // Ensure the address is in the database
        Address foundAddress = addressService.read(address.getId());
        System.out.println(foundAddress);

        assertNotNull(foundAddress);
        assertEquals(address.getId(), foundAddress.getId());
    }

    @Test
    void update() {
        Address createdAddress = addressService.create(address);
        createdAddress = new Address.Builder()
                .copy(createdAddress)
                .setAddressLine1("new Address updated address")
                .build();
        Address updatedAddress = addressService.update(createdAddress);
        System.out.println(updatedAddress);
        assertNotNull(updatedAddress);
        assertEquals("new Address updated address", updatedAddress.getAddressLine1());
    }

    @Test
    void findAll() {
        addressService.create(address);
        List<Address> addresses = addressService.findAll();

        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals(1, addresses.size());
    }

}
