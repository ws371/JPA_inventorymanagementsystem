package com.controllers;

import com.entities.User;
import com.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            if (user.getEmail().equals(loginRequest.getEmail()) &&
                    user.getPasswordHash().equals(loginRequest.getPasswordHash())) {
                return ResponseEntity.ok("Login successful");
            }
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User newUser) {
        userService.addUser(newUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
