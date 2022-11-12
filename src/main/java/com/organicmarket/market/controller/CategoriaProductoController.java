package com.organicmarket.market.controller;

import com.organicmarket.market.entities.CategoriaProducto;
import com.organicmarket.market.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaProducto>> searchCategorias(){
        List<CategoriaProducto> categoria = categoriaProductoRepository.findAll();

        return new ResponseEntity<List<CategoriaProducto>>(categoria, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/categoria")
    public ResponseEntity<CategoriaProducto> save(@RequestBody CategoriaProducto categoriaProducto){
        CategoriaProducto newCategoriaProducto = CategoriaProducto.builder().name(categoriaProducto.getName()).build();
        categoriaProductoRepository.save(newCategoriaProducto);
        return new ResponseEntity<CategoriaProducto>(newCategoriaProducto, HttpStatus.CREATED);
    }
}
