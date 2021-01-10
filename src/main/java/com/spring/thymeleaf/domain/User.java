package com.spring.thymeleaf.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = { "pw", "grade" })
public class User {

    private int id;
    private int age;
    private String name;
    private String address;
}
