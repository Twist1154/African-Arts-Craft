package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserfactoryTest {

    @Test
    void buildUser_Success() {
        long user_id = 1;
        String username = "Twist11577";
        String password = "password";
        String email = "rethabile@gmail.com";
        String first_name = "Rethabile";
        String last_name = "Ntsekhe";
        LocalDate created_at = LocalDate.of(2023, 7, 24);
        LocalDate updated_at = LocalDate.of(2023, 8, 24);

        User user = Userfactory.buildUser(user_id, username, password, email, first_name, last_name, created_at, updated_at);

        assertNotNull(user);
        assertEquals(username, user.getUsername());
        assertEquals(password, user.getPassword());
        assertEquals(email, user.getEmail());
        assertEquals(first_name, user.getFirstName());
        assertEquals(last_name, user.getLastName());
        assertEquals(created_at, user.getCreatedAt());
        assertEquals(updated_at, user.getUpdatedAt());
    }

    @Test
    void buildUser_Failure_NullFields() {
        long user_id = 1;
        String username = null;
        String password = "password";
        String email = "rethabile@gmail.com";
        String first_name = "Rethabile";
        String last_name = "Twist";
        LocalDate created_at = LocalDate.of(2024, 7, 24);
        LocalDate updated_at = LocalDate.of(2024, 8, 24);

        User user = Userfactory.buildUser(user_id, username, password, email, first_name, last_name, created_at, updated_at);

        assertNull(user);
    }

    @Test
    void buildUser_Failure_InvalidEmail() {
        long user_id = 1;
        String username = "Twist11577";
        String password = "password123";
        String email = "rethabile.gmail.com";
        String first_name = "Rethabile";
        String last_name = "Twist";
        LocalDate created_at = LocalDate.of(2023, 7, 24);
        LocalDate updated_at = LocalDate.of(2023, 8, 24);

        User user = Userfactory.buildUser(user_id, username, password, email, first_name, last_name, created_at, updated_at);

        assertNull(user);
    }
}
