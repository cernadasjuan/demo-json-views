package com.onready.jsonviews.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.onready.jsonviews.view.RoleView;

public class Person {

    @JsonView(RoleView.Admin.class)
    private Long id;
    @JsonView(RoleView.User.class)
    private String name;
    @JsonView(RoleView.User.class)
    private String lastName;
    @JsonView(RoleView.User.class)
    private int age;
    @JsonView(RoleView.Admin.class)
    private String password;

    public Person(Long id, String name, String lastName, int age, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
