package com.example.MyFirstMock.controller;

import com.example.MyFirstMock.dto.User;
import com.example.MyFirstMock.service.DbService;
import com.example.MyFirstMock.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@RestController
public class MockController {
    DbService dbService = new DbService();
    FileService fileService = new FileService();

    @GetMapping("/user")
    ResponseEntity<?> getUser(@RequestParam(required = true) String login) throws SQLException {
        User user = dbService.getUserByLogin(login);
        fileService.logUser(user);
        return ResponseEntity.ok(user.toString());
    }

    @GetMapping("/file")
    ResponseEntity<?> getUserFromFile() {
        return ResponseEntity.ok(fileService.getUserFromFile());
    }

    @PostMapping(value = "/user", consumes = {"application/json"})
    ResponseEntity<?> postUser(@RequestBody Map<String, String> user) {
        if ((user.size() > 3) || (!user.containsKey("login") || (!user.containsKey("password")) || (!user.containsKey("email")) || (user.containsValue(""))))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad JSON");
        else return ResponseEntity.ok(dbService.setUser(new User(user.get("login"), user.get("password"), user.get("email"))));
    }
}
