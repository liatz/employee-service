package com.microservices.employeeservice.repository;
import com.microservices.employeeservice.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservices.employeeservice.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> deleteByName(String name);

    @Query(value = "Select * From Employee e where name like '%x'", nativeQuery = true)
    List<Employee> employeWithXInName();

    @Query(name = "query_get_employees_with_x_name")
    List<Employee> employeWithXInNameUsingNamedQuery();

}