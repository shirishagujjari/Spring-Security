package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
//@AttributeOverrides(
//        {
//                @AttributeOverride(name = "id", column = @Column(name = "id")),
//                @AttributeOverride(name = "name", column = @Column(name = "name")),
//                @AttributeOverride(name = "email", column = @Column(name = "email")),
//                @AttributeOverride(name = "address", column = @Column(name = "address")),
//})
//@PrimaryKeyJoinColumn(name = "reg_id")
public class RegularEmployee extends Employee {
    private Integer bonus;
}
