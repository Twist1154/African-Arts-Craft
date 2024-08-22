package za.ac.cput.service;

import za.ac.cput.domain.Order_Items;

/**
 * IOrderItemsService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

public interface IOrderItemsService extends IService<Order_Items, Long> {
    void deleteById(Long id);
}
