package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@XmlRootElement
public class Employee {
    private String id;
    @XmlElement
    private String name;
    private String email;
    private Address address;
    private List<Task> taskList;

}
