package com.organicmarket.market.controller;

import com.organicmarket.market.entities.CategoriaProducto;
import com.organicmarket.market.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoriaProductoController {
    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @GetMapping("/categoria")
    public ResponseEntity<List<CategoriaProducto>> getAllCategoriaProducto(){
        List<CategoriaProducto> categoriaProductos=categoriaProductoRepository.findAll();
        return new ResponseEntity<List<CategoriaProducto>>(categoriaProductos, HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/categoria")
    public ResponseEntity<CategoriaProducto> createCategoriaProducto(@RequestBody CategoriaProducto categoriaProducto) {
        CategoriaProducto newCategoriaProducto =
                categoriaProductoRepository.save(
                        new CategoriaProducto(categoriaProducto.getName())
                );
        return new ResponseEntity<CategoriaProducto>(newCategoriaProducto, HttpStatus.CREATED);
    }

    @GetMapping("/categoria/{name}")
    public ResponseEntity<List<CategoriaProducto>> findByNameLikeSQL(@PathVariable("name") String name){
        List<CategoriaProducto> categoriaProductos=categoriaProductoRepository.findByNameLikeSQL(name);
        if(categoriaProductos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoriaProductos, HttpStatus.OK);
    }
}
