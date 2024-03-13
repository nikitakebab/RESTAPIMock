package com.example.MyFirstMock.service;

import com.example.MyFirstMock.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.RandomAccess;
import java.util.stream.Stream;

public class FileService {

    final static String filename = "users.txt";

    public String getUserFromFile(){

        try (Stream<String> stream = Files.lines(Paths.get(filename), Charset.defaultCharset());
             BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            int count = (int) stream.count();
            String line = null;
            for (int i = 0; i <= new Random().nextInt(count); i++) {
                line = fileReader.readLine();
            }
            return line;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    public void logUser(User user) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(user.toString());
            writer.newLine();
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
