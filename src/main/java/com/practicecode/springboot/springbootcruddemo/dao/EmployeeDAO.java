package com.practicecode.springboot.springbootcruddemo.dao;

import com.practicecode.springboot.springbootcruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
}
