package com.example.MyFirstMock.controller;

import com.example.MyFirstMock.DTO.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MockController {

    @GetMapping("/user")
    ResponseEntity<?> getUser() {
        return ResponseEntity.ok("{\"login\":\"example\",\"password\":\"password\"}");
    }

    @PostMapping(value = "/user", consumes = {"*/*"})
    ResponseEntity<?> postUser(
            @RequestBody User user
    ) {
        if ((user.getLogin() == null) || (user.getPassword() == null)) return ResponseEntity.internalServerError().build();
        return ResponseEntity.ok(user);
    }
}
