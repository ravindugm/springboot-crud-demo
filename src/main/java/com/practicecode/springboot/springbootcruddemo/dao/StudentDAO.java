package com.practicecode.springboot.springbootcruddemo.dao;

import com.practicecode.springboot.springbootcruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> findAll();

    public Student findById(int theId);

    public void save(Student theStudent);

    public void deleteById(int theId);
}
