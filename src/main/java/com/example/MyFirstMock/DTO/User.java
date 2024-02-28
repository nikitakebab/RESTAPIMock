package com.example.MyFirstMock.DTO;

import lombok.*;

import java.util.Date;

@Getter
//@NoArgsConstructor
public class User {

    @Setter
    private String login;

    @Setter
    private String password;
    private final Date currentTime = new Date();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
