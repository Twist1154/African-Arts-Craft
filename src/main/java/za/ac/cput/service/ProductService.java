package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Product;
import za.ac.cput.repository.ProductRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * ProductService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */
@Slf4j
@Service
@Transactional
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product read(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findBySubCategories_Id(categoryId);
    }

    @Override
    public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }


    @Override
    public List<Product> findByCreatedAtAfter(LocalDate createdAt) {
        return productRepository.findByCreatedAtAfter(createdAt);
    }

    @Override
    public List<Product> findByUpdatedAtBefore(LocalDate updatedAt) {
        return productRepository.findByUpdatedAtBefore(updatedAt);
    }

}
