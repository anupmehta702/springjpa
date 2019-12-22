package com.spring.jpa.springjpa;

import com.spring.jpa.springjpa.dept.configuration.DepartmentTransactionConfiguration;
import com.spring.jpa.springjpa.emp.configuration.EmployeeTransactionConfiguration;
import com.spring.jpa.springjpa.dept.model.Department;
import com.spring.jpa.springjpa.emp.model.Employees;
import com.spring.jpa.springjpa.dept.repository.DepartmentRepository;
import com.spring.jpa.springjpa.emp.model.Person;
import com.spring.jpa.springjpa.emp.repository.EmployeeRepository;

import com.spring.jpa.springjpa.emp.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringjpaApplication.class)
@ContextConfiguration(classes={EmployeeTransactionConfiguration.class, DepartmentTransactionConfiguration.class})
@EnableTransactionManagement
public class JPAMultipleDBTest {

    @Autowired
    private EmployeeRepository eRepository;

    @Autowired
    private DepartmentRepository dRepository;


    @Autowired
    private PersonRepository pRepository;

    @Test
    @Transactional("employeeTransactionManager")
    public void findEmployee(){
        Employees e = new Employees("Test2","Test2","test@email.com");
        eRepository.save(e);

        assertTrue(eRepository.findAll().contains(e));

    }

    @Test
    @Transactional("employeeTransactionManager")
    public void findEmployeeByName(){
        Employees e = new Employees("Test3","Test3","test@email.com");
        eRepository.save(e);
        assertTrue(eRepository.findByFirstName("Test3").contains(e));

    }

    @Test
    @Transactional("employeeTransactionManager")
    public void findPersonByName(){
        Person p = new Person("Anup Mehta");
        pRepository.save(p);
        assertTrue(pRepository.findByName("Anup Mehta").contains(p));

    }

    @Test
    @Transactional("departmentTransactionManager")
    public void findDepartment(){
        Department d = new Department("computer","pune");
        dRepository.save(d);

        assertTrue(dRepository.findAll().contains(d));

    }
}
