package za.ac.cput.service;

import za.ac.cput.domain.CartItems;

import java.util.List;

public interface ICartItemService extends IService<CartItems, Long> {

    void delete(Long id);

    List<CartItems> findByCart_Id(Long cartId);

    List<CartItems> findByProduct_Id(Long productId);


}
