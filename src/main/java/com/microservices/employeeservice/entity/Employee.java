package com.microservices.employeeservice.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Objects;

@NamedQueries(value = {
        @NamedQuery(name="query_get_employees_with_x_name",
        query = "Select e From Employee e where name like '%x'")
})


@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    private String role;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "joiningDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joiningDate;

    @Column(name = "retiringDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate retiringDate;

    @Column(name="dept")
    private String dept;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="addressid")
    private Address address;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Employee))
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
                && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", joiningDate=" + joiningDate +
                ", retiringDate=" + retiringDate +
                ", dept='" + dept + '\'' +
                ", address=" + address +
                '}';
    }
}