package com.example.MyFirstMock.controller;

import com.example.MyFirstMock.DTO.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;

@RestController
public class MockController {

    @GetMapping("/user")
    ResponseEntity<?> getUser() {
        return ResponseEntity.ok("{\"login\":\"example\",\"password\":\"password\"}");
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    ResponseEntity<?> postUser(@RequestBody Map<String, String> user) {
        try {
            if ((user.size() > 2) || (!user.containsKey("login") || (!user.containsKey("password")) || (user.containsValue(""))))
                throw new Exception("Wrong parameters");
            else return ResponseEntity.ok(new User(user.get("login"), user.get("password")));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
