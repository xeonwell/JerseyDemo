package com.xeonwell.JerseyDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * Created by xeonwell on 2017-04-24.
 */

public class User implements Serializable {
    public int id;
    public String firstName;
    public String lastName;
    @JsonIgnore
    public String password;
//    public int age;

    public User(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {
    }

    @Override
    public String toString() {
        return String.format("first name = %s, last name = %s", firstName, lastName);
    }
}
