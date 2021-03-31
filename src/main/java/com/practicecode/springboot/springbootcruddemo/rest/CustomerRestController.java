package com.practicecode.springboot.springbootcruddemo.rest;

import com.practicecode.springboot.springbootcruddemo.entity.Customer;
import com.practicecode.springboot.springbootcruddemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService theCustomerService) {
        this.customerService = theCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer findById(@PathVariable int customerId) {
        Customer customer = customerService.findById(customerId);

        if (customer == null) {
            throw new RuntimeException("Customer of id " + customerId + " is not found");
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer newCustomer) {
        newCustomer.setId(0);

        customerService.save(newCustomer);

        return newCustomer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer) {
        customerService.save(theCustomer);

        return theCustomer;

    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer theCustomer = customerService.findById(customerId);

        if (theCustomer == null) {
            throw new RuntimeException("Customer of id " + customerId + " not found");
        }

        customerService.deleteById(customerId);

        return "Delete the record of id: " + customerId;

    }
}
