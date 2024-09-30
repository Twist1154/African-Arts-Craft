package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.CartItems;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems, Long> {

    List<CartItems> findByCart_Id(Long cart_id);


    List<CartItems> findByProduct_Id(Long product_id);

    void deleteByCart_Id(Long cart_id);
}
