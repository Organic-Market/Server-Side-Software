package com.organicmarket.market.controller;

<<<<<<< Updated upstream
import com.organicmarket.market.entities.Mayorista;
=======
import com.organicmarket.market.DTO.CreateProducto;
import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.CategoriaProducto;
>>>>>>> Stashed changes
import com.organicmarket.market.entities.Producto;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.AgricultorRepository;
import com.organicmarket.market.repository.CategoriaProductoRepository;
import com.organicmarket.market.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoController {

    /*@Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Autowired
    private CategoriaProductoRepository categoriaProductoRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Producto>> getAllMayorista(){
        List<Producto> productos = productoRepository.findAll();

        return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable("id") Long id) {
        Producto productos = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));

        return new ResponseEntity<Producto>(productos,HttpStatus.OK);
    }

    @PostMapping("/products")
<<<<<<< Updated upstream
    public ResponseEntity<Producto> createProducto( @RequestBody Producto producto){
        Producto newProducto = productoRepository.save(
                new Producto(producto.getName(),
                        producto.getUnit_price(),
                        producto.getStock())
        );
        return new ResponseEntity<Producto>(newProducto, HttpStatus.CREATED);
=======
    public ResponseEntity<Producto> createProducto(@RequestBody CreateProducto createProducto) {

        Producto producto = new Producto();
        producto.setName(producto.getName());
        producto.setStock(producto.getStock());
        producto.setUnit_price(producto.getUnit_price());
        //producto.setAgricultor(agricultorRepository.findById(createProducto.getAgricultor_id()));
        //producto.setCategoriaProducto(categoriaProductoRepository.findById(createProducto.getCategoria_id()));

        productoRepository.save(producto);

        return new ResponseEntity<Producto>(producto,HttpStatus.CREATED);
>>>>>>> Stashed changes
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Producto> createProducto(@PathVariable("id") Long id, @RequestBody Producto producto){
        Producto productosUpdate = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));

        productosUpdate.setName(producto.getName());
        productosUpdate.setStock(producto.getStock());
        productosUpdate.setUnit_price(producto.getUnit_price());



        return new ResponseEntity<Producto>(productoRepository.save(productosUpdate),
                HttpStatus.OK);
    }

    @GetMapping("/products/agricultor/{id}")
    public ResponseEntity<List<Producto>> findByAllProductsAgricultorIdSQL(@PathVariable("id") Long id){
        List<Producto> products = productoRepository.findByAllProductsAgricultorIdSQL(id);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }*/


}
