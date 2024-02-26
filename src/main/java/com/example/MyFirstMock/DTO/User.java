package com.example.MyFirstMock.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {

    private String login;
    private String password;
    private final Date currentTime = new Date();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

}
