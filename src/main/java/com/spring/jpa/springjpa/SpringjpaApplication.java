package com.spring.jpa.springjpa;

import com.spring.jpa.springjpa.emp.model.Employees;
import com.spring.jpa.springjpa.emp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringjpaApplication implements CommandLineRunner {

    @Autowired
    EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringjpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testEmployeeTransaction();
    }

    @Transactional("employeeTransactionManager")
    public void testEmployeeTransaction(){
        Employees e = new Employees("Test1","Test2","test@email.com");
        repository.save(e);
        System.out.println("-->"+repository.findAll());

    }
}
