package data;

import com.microservices.employeeservice.EmployeeServiceApplication;
import com.microservices.employeeservice.entity.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeServiceApplication.class)
public class EmployeeRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EmployeeRepository repository;


    @Test
    public void contextLoads() {
    }

    @Test
    public void findById_basic() {
        Optional<Employee> employee = repository.findById(10001L);
        logger.info("employee {}", employee.isPresent());
        assertTrue(employee.isPresent());
    }

    @Test
    public void playingWithEmployeeRepository() {
        logger.info("employees -> {}", repository.findAll());
        logger.info("employees count -> {}", repository.count());
    }

    @Test
    public void sort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        logger.info("employees -> {}", repository.findAll(sort));
        logger.info("employees count -> {}", repository.count());
    }

    @Test
    public void findByName() {
        logger.info("employees findByName -> {}", repository.findByName("liat").stream().count());
        assertEquals(repository.findByName("liat").stream().count(), 1);
    }

}
