package com.example.MyFirstMock.controller;

import com.example.MyFirstMock.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MockController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleException(HttpMessageNotReadableException e){

//        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "There are unrecognized fields in request's body");
        return ResponseEntity.internalServerError().build();

    }

    @GetMapping("/user")
    ResponseEntity<?> getUser() {
        return ResponseEntity.ok("{\"login\":\"example\",\"password\":\"password\"}");
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    ResponseEntity<?> postUser(@RequestBody User user) throws HttpMessageNotReadableException{
        if ((user.getLogin() == null) || (user.getPassword() == null) || (user.getLogin().isBlank()) || (user.getPassword().isBlank()))
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid user's parameters");
        else return ResponseEntity.ok(user);
    }
}
