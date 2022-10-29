package com.organicmarket.market.controller;

import com.organicmarket.market.entities.User;
import com.organicmarket.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userRepository.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser=
                userRepository.save(
                        new User(user.getUsername(),
                                user.getPassword(),
                                user.getEmail())
                );
        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
