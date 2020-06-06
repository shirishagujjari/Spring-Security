package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Employee {
    private String id;
    private String name;
    private String email;
    private Address address;
    private List<Task> taskList;

}
