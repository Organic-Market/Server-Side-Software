package com.organicmarket.market.controller;

import com.organicmarket.market.converter.MayoristaConverter;
import com.organicmarket.market.dto.LoginRequestDTO;
import com.organicmarket.market.dto.LoginResponseDTO;
import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.MayoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class MayoristaController {

    @Autowired
    private MayoristaRepository mayoristaRepository;

    private final MayoristaConverter mayoristaConverter;

    public MayoristaController(MayoristaConverter mayoristaConverter){
        this.mayoristaConverter = mayoristaConverter;
    }

    @Transactional(readOnly = true)
    @GetMapping("/mayorista")
    public ResponseEntity<List<Mayorista>> searchAllMayorista(){
        List<Mayorista> mayoristas = mayoristaRepository.findAll();

        return new ResponseEntity<List<Mayorista>>(mayoristas, HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    @GetMapping("/mayorista/agricultor/{id}")
    public ResponseEntity<List<Mayorista>> findByAllCompradoresAgricultorIdSQL(@PathVariable("id") Long id){
        List<Mayorista> mayoristas = mayoristaRepository.findByAllCompradoresAgricultorIdSQL(id);
        if(mayoristas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(mayoristas, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/mayorista")
    public ResponseEntity<Mayorista> saveMayorista(@RequestBody Mayorista mayorista) {

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

    @Transactional(readOnly = true)
    @PostMapping("/mayorista/signin")
    public ResponseEntity<LoginResponseDTO> signInMayorista(@RequestBody LoginRequestDTO request) {
        Mayorista mayoristaSignin=mayoristaRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(()-> new ResourceNotFoundException("email y/o password incorrectos"));

        LoginResponseDTO response=mayoristaConverter.convertEntityToDto(mayoristaSignin);

        return new ResponseEntity<LoginResponseDTO>(response, HttpStatus.OK);
    }


}
