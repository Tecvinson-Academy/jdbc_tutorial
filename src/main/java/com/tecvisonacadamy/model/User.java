package com.tecvisonacadamy.model;

import java.sql.Date;

public class User {


    private String firstName;
    private String lastName;
    private String email;
    private Date dob;

    public User(String firstName, String lastName, String email, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
        return dob;
    }
}
