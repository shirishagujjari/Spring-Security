package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
    private String name;
    private Integer salary;

    public Person(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }
}
