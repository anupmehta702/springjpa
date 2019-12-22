package com.spring.jpa.springjpa.emp.model;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    public Person() {
    }

    public Person( String name) {
        this.name = name;
    }
}
