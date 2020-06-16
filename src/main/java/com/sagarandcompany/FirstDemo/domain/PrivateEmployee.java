package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
//@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "id"))})
public class PrivateEmployee extends Employee {
    private Integer time;
}
