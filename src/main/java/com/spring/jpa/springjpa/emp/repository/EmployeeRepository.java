package com.spring.jpa.springjpa.emp.repository;

import com.spring.jpa.springjpa.emp.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    List<Employees> findAll();

    @Query("select emp from Employees emp where first_name=(:fName)") //Employees is the name of class not table
    List<Employees> findByFirstName(@Param("fName") String firstName);

}
