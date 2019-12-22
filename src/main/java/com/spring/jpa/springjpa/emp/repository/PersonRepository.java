package com.spring.jpa.springjpa.emp.repository;

import com.spring.jpa.springjpa.emp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findAll();

    @Query("select emp from Person emp where name=(:fName)") //Employees is the name of class not table
    List<Person> findByName(@Param("fName") String name);

}
