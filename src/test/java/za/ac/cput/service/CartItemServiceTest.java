package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.repository.CartItemRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartItemServiceTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartItemService cartItemService;

    private Cart_Items cartItem = CartItemFactory.buildCartItem(012, 013, 014, 123);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    @Order(1)
    void create() {
        when(cartItemRepository.save(any(Cart_Items.class))).thenReturn(cartItem);
        Cart_Items created = cartItemService.create(cartItem);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        when(cartItemRepository.findById(cartItem.getCart_item_id())).thenReturn(Optional.of(cartItem));
        Cart_Items read = cartItemService.read(cartItem.getCart_item_id());
        assertNotNull(read, "Read result should not be null");
        assertEquals(cartItem, read, "Read result should match the cartItem");
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Cart_Items newCartItems = new Cart_Items.Builder().copy(cartItem).setCart_item_id(18).build();
        when(cartItemRepository.save(any(Cart_Items.class))).thenReturn(newCartItems);
        Cart_Items updated = cartItemService.update(newCartItems);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(4)
    void delete() {
        doNothing().when(cartItemRepository).deleteById(cartItem.getCart_item_id());
        cartItemService.delete(cartItem.getCart_item_id());
        System.out.println("Successfully deleted cart id");
    }

    @Test
    @Order(5)
    void getAll() {
        when(cartItemRepository.findAll()).thenReturn(Collections.singletonList(cartItem));
        List<Cart_Items> cartItemsList = cartItemService.getAll();
        assertNotNull(cartItemsList);
        assertEquals(1, cartItemsList.size());
        System.out.println(cartItemsList);
    }

    @Test
    @Order(6)
    void getCartItemsByCartId() {
        when(cartItemRepository.findByCartId(cartItem.getCart_id())).thenReturn(Collections.singletonList(cartItem));
        List<Cart_Items> cartItems = cartItemService.getCartItemsByCartId(cartItem.getCart_id());
        assertNotNull(cartItems);
        assertEquals(1, cartItems.size());
    }

    @Test
    @Order(7)
    void getCartItemsByProductId() {
        when(cartItemRepository.findByProductId(cartItem.getProduct_id())).thenReturn(Collections.singletonList(cartItem));
        List<Cart_Items> cartItems = cartItemService.getCartItemsByProductId(cartItem.getProduct_id());
        assertNotNull(cartItems);
        assertEquals(1, cartItems.size());
    }
}
