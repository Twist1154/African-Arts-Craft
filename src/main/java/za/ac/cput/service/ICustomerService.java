package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;

import java.util.List;

/**
 * ICustomerService.java
 *
 * @author Your Name
 * @date 24-Jul-24
 */

@Service
public interface ICustomerService extends IService<Customer, Long> {

    void delete(Long id);

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

    List<Customer> findByEmail(String email);
}
