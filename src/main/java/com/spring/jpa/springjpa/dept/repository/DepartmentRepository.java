package com.spring.jpa.springjpa.dept.repository;

import com.spring.jpa.springjpa.dept.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
