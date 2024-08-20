package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.ICustomerService;

import java.time.LocalDate;
import java.util.List;

/**
 * CustomerService.java
 *
 * @author Your Name
 * @date 24-Jul-24
 */

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer read(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findByFirstName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public List<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public List<Customer> findCustomersCreatedAfter(LocalDate createdAt) {
        return customerRepository.findCustomersCreatedAfter(createdAt);
    }
}
