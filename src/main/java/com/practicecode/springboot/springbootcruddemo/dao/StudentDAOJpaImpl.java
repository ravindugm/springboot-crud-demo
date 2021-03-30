package com.practicecode.springboot.springbootcruddemo.dao;

import com.practicecode.springboot.springbootcruddemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentDAOJpaImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;
    }

    @Override
    public List<Student> findAll() {

        // create a query
        Query theQuery = entityManager.createQuery("from Student");

        // execute query and get result list
        List<Student> students = theQuery.getResultList();

        // return results
        return students;
    }

    @Override
    public Student findById(int theId) {

        // get student
        Student theStudent = entityManager.find(Student.class, theId);

        // return student
        return theStudent;
    }

    @Override
    public void save(Student theStudent) {
        // save or update the student
        Student student = entityManager.merge(theStudent);

        // update with the id from database then can generate id for save/ insert
        theStudent.setId(student.getId());
    }

    @Override
    public void deleteById(int theId) {
        // delete object with the primary key
        Query theQuery = entityManager.createQuery("delete from Student where id=:studentId");

        theQuery.setParameter("studentId", theId);

        theQuery.executeUpdate();
    }
}
