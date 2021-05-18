package com.microservices.employeeservice.service;

import java.util.List;

import com.microservices.employeeservice.entity.Employee;

public interface EmployeeService {

    Employee createEmployee(Employee emp);
    Employee updateEmployee(Employee emp);
    Employee getEmployee(Long empId);
    void deleteEmployee(Long empId);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByName(String name);


}