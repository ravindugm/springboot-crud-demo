package com.practicecode.springboot.springbootcruddemo.rest;

import com.practicecode.springboot.springbootcruddemo.entity.Employee;
import com.practicecode.springboot.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    // inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET/employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee of id " + employeeId + " not found");
        }

        return theEmployee;
    }

    // add mapping for POST/employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // In case pass an id in JSON set id to 0
        // This is to force a save new item instead of update

        theEmployee.setId(0);

        employeeService.save(theEmployee);

        return theEmployee;
    }
}
