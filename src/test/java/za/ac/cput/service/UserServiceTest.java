package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        user = new User.Builder()
                .setId(1L)
                .setUsername("Twist11577")
                .setPassword("password")
                .setEmail("rethabile@gmail.com")
                .setFirst_name("Rethabile")
                .setLast_name("Ntsekhe")
                .setCreated_at(LocalDate.of(2024, 7, 24))
                .setUpdated_at(LocalDate.of(2024, 8, 24))
                .build();
    }

    @Test
    void testCreate() {
        User createdUser = userService.create(user);
        assertNotNull(createdUser);
        assertEquals(user.getUsername(), createdUser.getUsername());
    }

    @Test
    void testRead() {
        User createdUser = userService.create(user);
        User foundUser = userService.read(String.valueOf(createdUser.getId()));
        assertNotNull(foundUser);
        assertEquals(user.getUsername(), foundUser.getUsername());
    }

    @Test
    void testUpdate() {
        User createdUser = userService.create(user);
        User updatedUser = new User.Builder()
                .copy(createdUser)
                .setUsername("Ntsekhe_1154")
                .build();
        User result = userService.update(updatedUser);
        assertNotNull(result);
        assertEquals("Ntsekhe_1154", result.getUsername());
    }

    @Test
    void testDelete() {
        User createdUser = userService.create(user);
        userService.delete(String.valueOf(createdUser.getId()));
        User foundUser = userService.read(String.valueOf(createdUser.getId()));
        assertNull(foundUser);
    }

    @Test
    void testFindAll() {
        userService.create(user);
        List<User> users = userService.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    void testFindByUsername() {
        userService.create(user);
        List<User> users = userService.findByUsername("Twist11577");
        assertFalse(users.isEmpty());
    }

    @Test
    void testFindByEmail() {
        userService.create(user);
        List<User> users = userService.findByEmail("rethabile@gmail.com");
        assertFalse(users.isEmpty());
    }

    @Test
    void testFindUsersByLastName() {
        userService.create(user);
        List<User> users = userService.findByLastName("Ntsekhe");
        assertFalse(users.isEmpty());
    }

    @Test
    void testFindUsersCreatedAfter() {
        userService.create(user);
        List<User> users = userService.findUsersCreatedAfter(LocalDate.of(2024, 7, 1));
        assertFalse(users.isEmpty());
    }
}
