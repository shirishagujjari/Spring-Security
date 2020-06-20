package com.sagarandcompany.FirstDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private Integer salary;
    @OneToOne(cascade = CascadeType.ALL)
    private Department department;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
}
