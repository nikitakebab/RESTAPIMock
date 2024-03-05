package com.example.MyFirstMock.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
public class User {
    private String login;
    private String password;
    private Date date;
    private String email;

    public User(String login, String password, Date date, String email) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }

    public User(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;
        this.date = new Date(new java.util.Date().getTime());
    }

    @Override
    public String toString() {
        return "{\"login\":\"" + login + "\",\"password\":\"" + password + "\",\"email\":\"" + email + "\",\"date\":\"" + date + "\"}";
    }
}

