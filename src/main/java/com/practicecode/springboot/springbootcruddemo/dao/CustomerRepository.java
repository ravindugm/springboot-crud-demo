package com.practicecode.springboot.springbootcruddemo.dao;

import com.practicecode.springboot.springbootcruddemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // No need to write any code - JpaRepository has CRUD methods

}
