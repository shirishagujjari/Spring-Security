package com.sagarandcompany.FirstDemo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@XmlRootElement
public class Address {
    private String city;
}
