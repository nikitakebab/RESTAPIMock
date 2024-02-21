package com.example.MyFirstMock.DTO;

import java.util.Date;

public class POSTResponseEntity {

    private String login;
    private String password;
    private Date currentTime;

    public POSTResponseEntity(String login, String password) {
        this.login = login;
        this.password = password;
        this.currentTime = new Date();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }
}
