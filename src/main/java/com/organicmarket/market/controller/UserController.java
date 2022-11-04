package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.entities.User;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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
    @Transactional
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

    @Transactional
    @PutMapping("/users/{id}")
    public ResponseEntity<User> createUser(@PathVariable("id") Long id, @RequestBody User user) {
        User createUser = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));
        createUser.setUsername(user.getUsername());
        createUser.setPassword(user.getPassword());
        createUser.setEmail(user.getEmail());

        return new ResponseEntity<User>(userRepository.save(createUser),
                HttpStatus.OK);
    }

}
