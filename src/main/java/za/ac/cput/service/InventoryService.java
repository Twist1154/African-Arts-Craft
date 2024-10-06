package za.ac.cput.service;

import za.ac.cput.domain.InventoryItem;

/**
 * InventoryService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 06-Oct-24
 */

public interface InventoryService extends IService<InventoryItem, Long> {
    void deleteById(Long id);
}
