package com.gutousu.dynamic_switch_data_source.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "user")
public class user
{
    @Id
    @GenericGenerator(name = "autoId", strategy = "increment")
    @GeneratedValue(generator = "autoId")
    private Integer id;
    private String name;
    private Integer age;

    public user() {
    }

    public user(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
