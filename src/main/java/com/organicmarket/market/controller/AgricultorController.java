package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.repository.AgricultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AgricultorController {
    @Autowired
    private AgricultorRepository agricultorRepository;

    @GetMapping("/agricultor")
    public ResponseEntity<List<Agricultor>> getAllAgricultores(){
        List<Agricultor> agricultor=agricultorRepository.findAll();
        return new ResponseEntity<List<Agricultor>>(agricultor, HttpStatus.OK);
    }
    @PostMapping("/agricultor")
    public ResponseEntity<Agricultor> createUser(@RequestBody Agricultor agricultor) {
        Agricultor newAgricultor=
                agricultorRepository.save(
                        new Agricultor(agricultor.getName(),
                                agricultor.getLastname(),
                                agricultor.getAddress(),
                                agricultor.getUser())
                );
        return new ResponseEntity<Agricultor>(newAgricultor, HttpStatus.CREATED);
    }
}
