package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.InventoryItem;

import java.util.List;

/**
 * InventoryRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 30-Sep-24
 */
@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long> {


    List<InventoryItem> findInventoryItemByVendorLocation(String vendLocation);

    List<InventoryItem> findInventoryItemByQuantityGreaterThan(int itemQuantity);
}
