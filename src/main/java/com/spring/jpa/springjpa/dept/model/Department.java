package com.spring.jpa.springjpa.dept.model;


import javax.persistence.*;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="dept_name")
    private String deptName;
    @Column(name="city")
    private String city;

    public Department() {
        //Framework required
    }

    public Department( String deptName, String city) {
        this.deptName = deptName;
        this.city = city;
    }
}
