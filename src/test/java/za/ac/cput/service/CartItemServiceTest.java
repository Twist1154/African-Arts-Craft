/*
package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.CartItemFactory;
import za.ac.cput.repository.CartItemRepository;

import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartItemServiceTest {

    private CartItemRepository cartItemRepository;
    @Autowired
    private CartItemService cartItemService;
    Cart cart = new Cart();
    Product product = new Product();
    private CartItems cartItem = CartItemFactory.buildCartItem(2L, cart, product, 123);

    @BeforeEach
   */
/* void setUp() {
        MockitoAnnotations.openMocks(this);
        cartItem = new Cart_Items.Builder()
                .setCart_item_id(1)
                .setId(100)
                .setProductId(200)
                .setQuantity(5)
                .build();




    }*//*


    @Test
    @Order(1)
    void create() {
        //when(cartItemRepository.create(cartItem)).thenReturn(cartItem);

        Cart_Items created = cartItemService.create(cartItem);
        assertNotNull(created);
        //assertEquals(cartItem, created);
        System.out.println(created);

        //verify(cartItemRepository, times(1)).create(cartItem);
    }

    @Test
    @Order(2)
    void read() {
        //when(cartItemRepository.read(cartItem.getCart_item_id())).thenReturn(Optional.of(cartItem));

        Cart_Items read = cartItemService.read(cartItem.getId());
        assertNotNull(read);
        assertEquals(cartItem, read);
        System.out.println(read);

        // verify(cartItemRepository, times(1)).read(cartItem.getCart_item_id());
    }

    @Test
    @Order(3)
    void update() {
        // when(cartItemRepository.create(cartItem)).thenReturn(cartItem);
        Cart_Items newCartItems = new Cart_Items.Builder().copy(cartItem).setId(18)
                .build();

        Cart_Items updated = cartItemService.update(newCartItems);
        assertNotNull(updated);
        System.out.println(updated);

        //verify(cartItemRepository, times(1)).create(cartItem);
    }

    @Test
    @Order(4)
    void delete() {
        cartItemService.delete(cartItem.getId());
        System.out.println("Successfully deleted cart id");
        //verify(cartItemRepository, times(1)).deleteById(cartItem.getCart_item_id());
    }

    @Test
    @Order(5)
    void getAll() {
        //when(cartItemRepository.findAll()).thenReturn(Collections.singletonList(cartItem));

        List<Cart_Items> cartItemsList = cartItemService.getAll();
        assertNotNull(cartItemsList);
        //assertEquals(1, cartItemsList.size());
        System.out.println(cartItemsList);

        //verify(cartItemRepository, times(1)).findAll();
    }


  */
/*  @Test
    @Order(6)
    void getCartItemsByCartId() {
        when(cartItemRepository.findByCartId(cartItem.getCart_id())).thenReturn(Collections.singletonList(cartItem));

        List<Cart_Items> cartItems = cartItemService.getCartItemsByCartId(cartItem.getCart_id());
        assertNotNull(cartItems);
        //assertEquals(1, cartItems.size());

        //verify(cartItemRepository, times(1)).findByCartId(cartItem.getCart_id());
    }*//*


    @Test
    @Order(7)
    void getCartItemsByProductId() {
        when(cartItemRepository.findByProductId(cartItem.getId())).thenReturn(Collections.singletonList(cartItem));

        List<Cart_Items> cartItems = cartItemService.getCartItemsByProductId(cartItem.getId());
        assertNotNull(cartItems);
        //assertEquals(1, cartItems.size());
        //verify(cartItemRepository, times(1)).findByProductId(cartItem.getProductId());
    }
}
*/
