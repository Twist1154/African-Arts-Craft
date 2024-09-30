package za.ac.cput.service;

import za.ac.cput.domain.Product;

import java.time.LocalDate;
import java.util.List;

/**
 * IProductService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 27-Jul-24
 */

public interface IProductService extends IService<Product, Long> {
    void delete(Long id);

    List<Product> findByName(String name);

    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    List<Product> findByCreatedAtAfter(LocalDate createdAt);

    List<Product> findByUpdatedAtBefore(LocalDate updatedAt);

}