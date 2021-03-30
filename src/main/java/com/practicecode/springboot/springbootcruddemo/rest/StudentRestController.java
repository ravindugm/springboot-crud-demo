package com.practicecode.springboot.springbootcruddemo.rest;

import com.practicecode.springboot.springbootcruddemo.entity.Student;
import com.practicecode.springboot.springbootcruddemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService theStudentService) {
        this.studentService = theStudentService;
    }

    @GetMapping("/students")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/students/{studentId}")
    public Student findById(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("The student of id " + studentId + " can not found");
        }

        return theStudent;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student theStudent) {
        theStudent.setId(0);

        studentService.save(theStudent);

        return theStudent;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student theStudent) {
        studentService.save(theStudent);

        return theStudent;
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        Student theStudent = studentService.findById(studentId);

        if (theStudent == null) {
            throw new RuntimeException("There is no student using id " + studentId);
        }

        studentService.deleteById(studentId);

        return "Delete student of id " + studentId;
    }

}
