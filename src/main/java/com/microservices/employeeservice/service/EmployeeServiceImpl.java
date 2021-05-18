package com.microservices.employeeservice.service;

import java.util.List;

import com.microservices.employeeservice.EmployeeNotFoundException;
import com.microservices.employeeservice.repository.EmployeeRepository;
import com.microservices.employeeservice.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Employee updateEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException(empId));
    }

    public List<Employee> getEmployeeByName(String name){
        List<Employee> employees = employeeRepository.findByName(name);
        return employees;
    }

}
