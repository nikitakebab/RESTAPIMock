package com.example.MyFirstMock.controller;

import com.example.MyFirstMock.DTO.GETResponseEntity;
import com.example.MyFirstMock.DTO.POSTResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockController {

    @GetMapping("/data")
    ResponseEntity<GETResponseEntity> getData() {
        return new ResponseEntity<>(new GETResponseEntity(), HttpStatus.OK);
    }

    @GetMapping("/getstring")
    ResponseEntity<String> getStringData() {
        return new ResponseEntity<>("{\"login\":\"example\",\"password\":\"password\"}", HttpStatus.OK);
    }

    @PostMapping("/data")
    ResponseEntity<POSTResponseEntity> postData(
            @RequestParam(value = "login", required = true) String login,
            @RequestParam(value = "password", required = true) String password
    ) {
        return new ResponseEntity<>(new POSTResponseEntity(login, password), HttpStatus.OK);
    }
}
