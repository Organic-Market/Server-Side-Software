package com.organicmarket.market.controller;

import com.organicmarket.market.entities.CategoriaProducto;
import com.organicmarket.market.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")
public class CategoriaProductoController {

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaProducto>> getAllMayorista(){
        List<CategoriaProducto> categoria = categoriaProductoRepository.findAll();

        return new ResponseEntity<List<CategoriaProducto>>(categoria, HttpStatus.OK);
    }
}
