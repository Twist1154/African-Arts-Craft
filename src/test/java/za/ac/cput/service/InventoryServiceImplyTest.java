package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.InventoryItem;
import za.ac.cput.domain.Product;
import za.ac.cput.factory.InventoryFactory;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InventoryServiceImplyTest {

    @Autowired
    private InventoryServiceImply service; // Injecting InventoryService implementation

    @Autowired
    private ProductService productService; // Injecting ProductService for reading product details

    private Product product;
    private InventoryItem inventoryItem;

    @BeforeEach
    void setUp() {

        product = productService.read(3L);

        // Create a sample InventoryItem using InventoryFactory
        inventoryItem = InventoryFactory.buildInventory(
                null,
                product,
                10,
                "Cape Town",
                null
        );

        // Persist the inventory item for test setup
        inventoryItem = service.create(inventoryItem); // Save to initialize for further tests
        assertNotNull(inventoryItem); // Verify the object is not null
    }

    @Test
    @Order(1)
    void create() {
        InventoryItem newItem = InventoryFactory.buildInventory(
                null,
                product,
                5,
                "Johannesburg",
                null
        );
        InventoryItem createdItem = service.create(newItem);
        System.out.println("Created inventory item: " + createdItem);
        assertNotNull(createdItem);
        assertEquals("Johannesburg", createdItem.getVendorLocation());
    }

    @Test
    @Order(2)
    void read() {
        InventoryItem foundItem = service.read(inventoryItem.getId());
        System.out.println("Found inventory item: " + foundItem);
        assertNotNull(foundItem); // Check if the item is found
        assertEquals(inventoryItem.getId(), foundItem.getId());
    }

    @Test
    @Order(3)
    void update() {
        InventoryItem updatedItem = new InventoryItem.Builder()
                .copy(inventoryItem)
                .setVendorLocation("Durban")
                .build();

        InventoryItem result = service.update(updatedItem);
        System.out.println("Updated inventory item: " + result);
        assertNotNull(result);
        assertEquals("Durban", result.getVendorLocation());
    }

    @Test
    @Order(5)
    void deleteById() {
        service.deleteById(inventoryItem.getId());
        System.out.println("Deleted inventory item: " + inventoryItem);
        InventoryItem deletedItem = service.read(inventoryItem.getId());
        assertNull(deletedItem);
    }

    @Test
    @Order(4)
    void findAll() {
        List<InventoryItem> items = service.findAll();
        System.out.println("All Inventory Items: " + items.spliterator());
        assertFalse(items.isEmpty());
        assertTrue(items.contains(inventoryItem));
    }

    @Test
    @Order(6)
    void findByProduct_Id() {
        List<InventoryItem> items = service.findByProduct_Id(3L);
        System.out.println("Inventory Items by Product ID: " + items);
        assertFalse(items.isEmpty());
        assertTrue(items.contains(inventoryItem));
    }
}
