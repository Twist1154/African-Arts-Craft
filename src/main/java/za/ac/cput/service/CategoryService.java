package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Category;
import za.ac.cput.repository.CategoriesRepository;

import java.util.List;

/**
 * CategoryService.java
 *
 * author Rethabile Ntsekhe
 * Student Num: 220455430
 * date 30-Jul-24
 */
@Slf4j
@Service
@Transactional
public class CategoryService implements ICategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoryService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }


    @Override
    public Category create(Category category) {
        return categoriesRepository.save(category);
    }

    @Override
    public Category read(Long id) {
        return categoriesRepository.findById(id).orElse(null);
    }

    @Override
    public Category update(Category category) {
        Category existingCategory = read(category.getId());
        if (existingCategory != null) {
            Category updatedCategory = new Category.Builder()
                    .copy(category)
                    .setId(existingCategory.getId())
                    .setName(category.getName())
                    .build();
            return categoriesRepository.save(updatedCategory);
        }
        log.error("Attempted to update a non-existent Category with ID: {}", category.getId());
        return null;
    }

    @Override
    public List<Category> findAll() {
        return categoriesRepository.findAll();
    }
}
