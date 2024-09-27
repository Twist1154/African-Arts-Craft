package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Categories;

/**
 * CategoriesRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 30-Jul-24
 */

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}
