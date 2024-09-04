package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Users;

import java.util.List;

/**
 * Author: Masithembe Ndzotyana
 * Student Num:219145091
 * Date : 23 Aug 2024
 * CartRepository Class
 */



public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(Long userId);


}
