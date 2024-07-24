package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Order;
import za.ac.cput.domain.Users;

/**
 * UserRepo.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public interface UserRepo extends JpaRepository<Users, String> {
}
