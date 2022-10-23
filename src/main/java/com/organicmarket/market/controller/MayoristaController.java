package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.entities.Producto;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.MayoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MayoristaController {

    @Autowired
    private MayoristaRepository mayoristaRepository;

    @GetMapping("/mayorista")
    public ResponseEntity<List<Mayorista>> getAllMayorista(){
        List<Mayorista> mayoristas = mayoristaRepository.findAll();

        return new ResponseEntity<List<Mayorista>>(mayoristas,HttpStatus.OK);
    }
    @GetMapping("/mayorista/{id}")
    public ResponseEntity<Mayorista> getMayoristaById(@PathVariable("id") Long id) {
        Mayorista mayoristas = mayoristaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found Mayorista with id="+id));

        return new ResponseEntity<Mayorista>(mayoristas,HttpStatus.OK);
    }
    /*
    @PostMapping("/mayorista")
    public ResponseEntity<Mayorista> createMayorista(@RequestBody Mayorista mayorista){
        Producto newMayorista = mayoristaRepository.save(
                new Mayorista(mayorista.getName(),
                        mayorista.getLastName(),
                        mayorista.getAddress())
        );
        return new ResponseEntity<Mayorista>(newMayorista, HttpStatus.CREATED);
    }*/
}
