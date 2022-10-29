package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.MayoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MayoristaController {

    @Autowired
    private MayoristaRepository mayoristaRepository;

    @GetMapping("/mayorista")
    public ResponseEntity<List<Mayorista>> getAllMayorista(){
        List<Mayorista> mayoristas = mayoristaRepository.findAll();

        return new ResponseEntity<List<Mayorista>>(mayoristas, HttpStatus.OK);
    }
    @GetMapping("/mayorista/{id}")
    public ResponseEntity<Mayorista> getMayoristaById(@PathVariable("id") Long id) {
        Mayorista mayoristas = mayoristaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Mayorista with id="+id));

        return new ResponseEntity<Mayorista>(mayoristas,HttpStatus.OK);
    }
    @GetMapping("/mayorista/agricultor/{id}")
    public ResponseEntity<List<Mayorista>> findByAllCompradoresAgricultorIdSQL(@PathVariable("id") Long id){
        List<Mayorista> mayoristas = mayoristaRepository.findByAllCompradoresAgricultorIdSQL(id);
        if(mayoristas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mayoristas, HttpStatus.OK);
    }
}