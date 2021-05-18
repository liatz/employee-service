package com.microservices.employeeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(employeeService.createEmployee(emp), HttpStatus.CREATED);
    }

    @PutMapping(consumes = "application/json", produces = "application/json", path = "/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
        return new ResponseEntity<>(employeeService.updateEmployee(emp), HttpStatus.CREATED);
    }


    @GetMapping(path = "/employee/{name}/name", produces = "application/json")
    public List<Employee> getEmployeesByName(@PathVariable String name){
        List<Employee> employees = employeeService.getEmployeeByName(name);
        logger.info("employee {}",employees);
        return employees;
    }

    // Single item

    @GetMapping(path = "/employee/{empId}", produces = "application/json")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "empId") Long empId) {
        return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
    }

    @GetMapping(path = "/employees", produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/employee/{empId}", produces = "application/json")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "empId") Long empId) {
        employeeService.deleteEmployee(empId);
        return new ResponseEntity<>("Employee with EmployeeId : " + empId + " deleted successfully", HttpStatus.OK);
    }
}