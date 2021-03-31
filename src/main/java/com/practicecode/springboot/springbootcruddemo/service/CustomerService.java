package com.practicecode.springboot.springbootcruddemo.service;

import com.practicecode.springboot.springbootcruddemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> findAll();

    public Customer findById(int theId);

    public void save(Customer customer);

    public void deleteById(int theId);
}
