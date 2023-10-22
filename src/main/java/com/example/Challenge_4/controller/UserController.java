package com.example.Challenge_4.controller;

import com.example.Challenge_4.model.Users;
import com.example.Challenge_4.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
@Slf4j

public class UserController {
    @Autowired
    private UserService userService;

    // Menambahkan User Baru
    @PostMapping("/add")
    public ResponseEntity addUsers(@RequestBody Users users) {
        Users newUser = userService.addUsers(users);
        return ResponseEntity.ok("Add new user successful!");
    }

    // Mengupdate User
    @PutMapping("/update")
    public ResponseEntity updateUsers(@RequestBody Users users) {
        Users updatedUser = userService.updateUsers(users);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Menghapus User
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUsers(@PathVariable String userId) {
        userService.deleteUsers(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
}
