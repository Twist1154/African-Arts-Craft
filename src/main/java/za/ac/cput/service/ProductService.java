package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Products;
import za.ac.cput.repository.ProductRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

/**
 * ProductService.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

@Service
public class ProductService {
    private final JpaSort.Path rootLocation;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductService(@Value("${file.upload-dir}") String uploadDir) {
        this.rootLocation = Paths.get(uploadDir);
    }

    public Products saveProduct(String name, String description, double price, int stockQuantity, long categoryId, MultipartFile file) throws IOException {
        String filename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Files.copy(file.getInputStream(), this.rootLocation.resolve(filename));

        Products product = new Products.Builder()
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock_quantity(stockQuantity)
                .setCategory_id(categoryId)
                .setCreated_at(LocalDate.now())
                .setUpdated_at(LocalDate.now())
                .setImagePath(filename)
                .build();

        return productRepository.save(product);
    }

    public Products updateProduct(long id, String name, String description, double price, int stockQuantity, long categoryId, MultipartFile file) throws IOException {
        Optional<Products> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        Products existingProduct = existingProductOpt.get();

        // Delete the old image file if a new image is uploaded
        if (file != null && !file.isEmpty()) {
            String oldFilename = existingProduct.getImagePath();
            Files.deleteIfExists(this.rootLocation.resolve(oldFilename));

            String newFilename = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.rootLocation.resolve(newFilename));
            existingProduct = new Products.Builder()
                    .setImagePath(newFilename)
                    .copy(existingProduct)
                    .build();
        }

        existingProduct = new Products.Builder()
                .setProduct_id(existingProduct.getProduct_id())
                .setName(name)
                .setDescription(description)
                .setPrice(price)
                .setStock_quantity(stockQuantity)
                .setCategory_id(categoryId)
                .setCreated_at(existingProduct.getCreated_at())
                .setUpdated_at(LocalDate.now())
                .setImagePath(existingProduct.getImagePath())
                .build();

        return productRepository.save(existingProduct);
    }

    public void deleteProduct(long id) throws IOException {
        Optional<Products> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isEmpty()) {
            throw new IllegalArgumentException("Product not found");
        }

        Products existingProduct = existingProductOpt.get();

        // Delete the image file
        String filename = existingProduct.getImagePath();
        Files.deleteIfExists(this.rootLocation.resolve(filename));

        // Delete the product from the database
        productRepository.deleteById(id);
    }
}