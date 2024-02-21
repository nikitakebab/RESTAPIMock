package com.example.MyFirstMock.DTO;
import java.util.Date;

public class GETResponseEntity {
    public final String info = "you got this string";
    private Date currentTime;

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public GETResponseEntity() {
        this.currentTime = new Date();
    }
}
