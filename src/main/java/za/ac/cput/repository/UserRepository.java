package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.time.LocalDate;
import java.util.List;

/**
 * UserRepository.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //create Your own custom Methods here guys excluding CRUD Operations
    // This is where I can add my own database methods extending from the ones already
    // defined in the JPA Repository. This is an example of abstraction in practice.
    //in Short this is a way of saying you extend the JPARepository that will be implemented/used
    // in the service level
//---------------------------------------------------------------------------------------------------------

    @Query("SELECT u FROM User u WHERE u.username = :username")
    List<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.last_name = :last_name")
    List<User> findByLastName(String last_name);

    @Query("SELECT u FROM User u WHERE u.email = :email")
    List<User> findByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM users u WHERE u.created_at >= :createdAt", nativeQuery = true)
    List<User> findUsersCreatedAfter(@Param("createdAt") LocalDate createdAt);

    User findByEmailAndPassword(String email, String password);
}
