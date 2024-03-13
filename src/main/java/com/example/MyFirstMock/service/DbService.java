package com.example.MyFirstMock.service;

import com.example.MyFirstMock.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DbService {

    final static String dbUrl = "jdbc:postgresql://192.168.1.6:5432/demodb";
    final static String dbUser = "admin";
    final static String dbPassword = "password";


    public User getUserByLogin(String login) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet set = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            stmt = con.createStatement();

            String selectSql = "SELECT u.login, u.password, u.date, ue.email " +
                    "FROM users u " +
                    "JOIN user_emails ue ON u.login = ue.login " +
                    "WHERE u.login = '" + login + "'";

            set = stmt.executeQuery(selectSql);

            if (set.next()) {

                return new User(
                        set.getString("login"),
                        set.getString("password"),
                        set.getDate("date"),
                        set.getString("email")
                );
            }
            else throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The user was not found");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (set != null) {
                set.close();
            }
        }
    }


    public String setUser(User user) {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            String insertSql = "INSERT INTO users (login, password, date) " +
                    "VALUES (?, ?, ?); " +
                    "INSERT INTO user_emails (login, email) " +
                    "VALUES (?, ?); " +
                    "COMMIT;";
            try (PreparedStatement preparedStatement = con.prepareStatement(insertSql)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setDate(3, user.getDate());

                preparedStatement.setString(4, user.getLogin());
                preparedStatement.setString(5, user.getEmail());

                return preparedStatement.executeUpdate() + " lines have been changed";
            }
        } catch (SQLException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}

