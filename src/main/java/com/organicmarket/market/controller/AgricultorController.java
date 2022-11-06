package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.AgricultorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
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

    @GetMapping("/agricultor/{username}")
    public ResponseEntity<Agricultor> getAllAgricultor(@PathVariable("username") String username){
        Agricultor agricultor=agricultorRepository.findByUsername(username);
        return new ResponseEntity<>(agricultor, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/agricultor")
    public ResponseEntity<Agricultor> createUser(@RequestBody Agricultor agricultor) {

        Agricultor newAgricultor=
                agricultorRepository.save(
                        new Agricultor(agricultor.getName(),
                                agricultor.getLastname(),
                                agricultor.getAddress(),
                                agricultor.getUsername(),
                                agricultor.getPassword(),
                                agricultor.getEmail())
                );
        return new ResponseEntity<Agricultor>(newAgricultor, HttpStatus.CREATED);
    }

    //Actualizar informacion de usuario (agricultor)
    @Transactional
    @PutMapping("/agricultor/{id}")
    public ResponseEntity<Agricultor> createAgricultor(@PathVariable("id") Long id, @RequestBody Agricultor agricultor) {
        Agricultor agricultorUpdate = agricultorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));
        agricultorUpdate.setName(agricultor.getName());
        agricultorUpdate.setLastname(agricultor.getLastname());
        agricultorUpdate.setAddress(agricultor.getAddress());
        agricultorUpdate.setUsername(agricultor.getUsername());
        agricultorUpdate.setPassword(agricultor.getPassword());
        agricultorUpdate.setEmail(agricultor.getEmail());

        return new ResponseEntity<Agricultor>(agricultorRepository.save(agricultorUpdate),
                HttpStatus.OK);
    }
}
