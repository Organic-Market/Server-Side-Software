package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.entities.Producto;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.MayoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
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

    @GetMapping("/mayorista/{username}")
    public ResponseEntity<Mayorista> getMayoristaByUsername(@PathVariable("username") String username){
        Mayorista mayorista=mayoristaRepository.findByUsername(username);
        return new ResponseEntity<>(mayorista, HttpStatus.OK);
    }

    @GetMapping("/mayorista/agricultor/{id}")
    public ResponseEntity<List<Mayorista>> findByAllCompradoresAgricultorIdSQL(@PathVariable("id") Long id){
        List<Mayorista> mayoristas = mayoristaRepository.findByAllCompradoresAgricultorIdSQL(id);
        if(mayoristas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mayoristas, HttpStatus.OK);
    }

    //Actualizar informacion de usuario (mayorista)
    @Transactional
    @PutMapping("/mayorista/{id}")
    public ResponseEntity<Mayorista> createMayorista(@PathVariable("id") Long id, @RequestBody Mayorista mayorista) {
        Mayorista mayoristaUpdate = mayoristaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));
        mayoristaUpdate.setName(mayorista.getName());
        mayoristaUpdate.setLastname(mayorista.getLastname());
        mayoristaUpdate.setAddress(mayorista.getAddress());

        return new ResponseEntity<Mayorista>(mayoristaRepository.save(mayoristaUpdate),
                HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/mayorista")
    public ResponseEntity<Mayorista> createUser(@RequestBody Mayorista mayorista) {

        Mayorista newMayorista=
                mayoristaRepository.save(
                        new Mayorista(mayorista.getName(),
                                mayorista.getLastname(),
                                mayorista.getAddress(),
                                mayorista.getUsername(),
                                mayorista.getPassword(),
                                mayorista.getEmail())
                );
        return new ResponseEntity<Mayorista>(newMayorista, HttpStatus.CREATED);
    }
}
