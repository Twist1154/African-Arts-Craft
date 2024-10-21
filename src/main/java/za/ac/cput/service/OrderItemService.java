package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.repository.OrderItemsRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * OrderItemService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 09-Sep-24
 */

@Transactional
@Service
public class OrderItemService implements IOrderItemService {
    private final OrderItemsRepository repository;
    private static final Logger logger = Logger.getLogger(OrderItemService.class.getName());

    @Autowired
    public OrderItemService(OrderItemsRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return repository.save(orderItem);
    }

    @Override
    public OrderItem read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        OrderItem existingOrderItem = repository.findById(orderItem.getId()).orElse(null);
        if (existingOrderItem != null) {
            OrderItem updatedOrderItem = new OrderItem.Builder()
                    .copy(existingOrderItem)
                    .setProductID(orderItem.getProductID())
                    .setQuantity(orderItem.getQuantity())
                    .setPrice(orderItem.getPrice())
                    .setOrder(orderItem.getOrder())
                    .build();
            return repository.save(updatedOrderItem);
        } else {
            logger.warning("Attempt to update a non-existent order item with ID: " + orderItem.getId());
            return null;
        }
    }

    @Override
    public List<OrderItem> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // Log warning if trying to delete a non-existent order item
            logger.warning("Attempt to delete a non-existent order item with ID: " + id);
        }
    }

    @Override
    public List<OrderItem> findAllByOrder_Id(Long id) {
        return repository.findAllByOrder_Id(id);
    }


}

//package za.ac.cput.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import za.ac.cput.domain.OrderItem;


//import za.ac.cput.repository.OrderItemsRepository;
//
//import java.util.List;
//
/// **
// * OrderItemService.java
// * <p>
// * Author: Rethabile Ntsekhe
// * Student Num: 220455430
// * Date: 25-Aug-24
// */
//@Slf4j
//@Service
//@Transactional
//public class OrderItemService implements IOrderItemService {
//
//    private final OrderItemsRepository repository;
//
//    @Autowired
//    public OrderItemService(OrderItemsRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public OrderItem create(OrderItem orderItem) {
//        return repository.save(orderItem);
//    }
//
//    @Override
//    public OrderItem read(Long id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    @Override
//    public OrderItem update(OrderItem orderItem) {
//        OrderItem existingOrderItem = repository.findById(orderItem.getId()).orElse(null);
//        if (existingOrderItem != null) {
//            OrderItem updatedOrderItem = new OrderItem.Builder()
//                    .copy(existingOrderItem)
//                    .setOrder(orderItem.getOrder())
//                    .setProduct(orderItem.getProduct())
//                    .setQuantity(orderItem.getQuantity())
//                    .build();
//            return repository.save(updatedOrderItem);
//        } else {
//            log.warn("Attempt to update a non-existent order item with ID: {}", orderItem.getId());
//            return null;
//        }
//    }
//
//
//    @Override
//    public List<OrderItem> findAll() {
//        return repository.findAll();
//    }
//
//
//    @Override
//    public void deleteById(Long id) {
//        repository.deleteByOrder_Id(id);
//
//    }
//}