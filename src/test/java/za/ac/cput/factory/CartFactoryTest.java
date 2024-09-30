package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void buildCart() {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");

        LocalDate startDate = LocalDate.parse("01-02-24", formatter);
        LocalDate endDate = LocalDate.parse("05-02-24", formatter);

        User user = new User();

        Cart cart = CartFactory.buildCart(1L, user, 800.00);


        assertEquals(1, cart.getId());
        assertEquals(1001, cart.getId());
    }
}
