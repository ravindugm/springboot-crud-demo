package com.practicecode.springboot.springbootcruddemo.service;

import com.practicecode.springboot.springbootcruddemo.dao.CustomerRepository;
import com.practicecode.springboot.springbootcruddemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository theCustomerRepository) {
        this.customerRepository = theCustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> results = customerRepository.findById(theId);

        Customer theCustomer = null;

        if (results.isPresent()) {
            theCustomer = results.get();
        } else {
            throw new RuntimeException("Did not find customer id: " + theId);
        }

        return theCustomer;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);
    }
}
