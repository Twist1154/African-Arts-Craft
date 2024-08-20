package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.ICustomerService;

import java.util.List;

/**
 * CustomerController.java
 *
 * @author Sibabalwe Ngandana
 * @date 24-Jul-24
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping("/read/{customerId}")
    public Customer read(@PathVariable Long customerId) {
        return customerService.read(customerId);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @GetMapping("/getAll")
    public List<Customer> getAll() {
        return customerService.findAll();
    }
}
