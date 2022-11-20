package com.organicmarket.market.controller;

import com.organicmarket.market.Util.ProductoExcelExporter;
import com.organicmarket.market.Util.Util;
import com.organicmarket.market.entities.CategoriaProducto;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import org.springframework.transaction.annotation.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api")

public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaProductoRepository categoriaRepository;

    @Autowired
    private AgricultorRepository agricultorRepository;

    @Transactional(readOnly = true)
    @GetMapping("/products")
    public ResponseEntity<List<Producto>> search() {
        List<Producto> products=new ArrayList<>();
        List<Producto> productsAux=new ArrayList<>();

        productsAux=productoRepository.findAll();

        if(productsAux.size()>0){
            productsAux.stream().forEach((p)->{
                byte[] imageDescompressed = Util.decompressZLib(p.getPicture());
                p.setPicture(imageDescompressed);
                products.add(p);
            });
        }

        return new ResponseEntity<List<Producto>>(products, HttpStatus.OK);
    }


    //Obtener productos por ID
    @Transactional(readOnly = true)
    @GetMapping("/products/{id}")
    public ResponseEntity<Producto> searchProductById(@PathVariable("id") Long id) {
        Producto productos = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));

        return new ResponseEntity<Producto>(productos,HttpStatus.OK);
    }

    //Agregar productos

    @Transactional
    @PostMapping("/products")
    //public ResponseEntity<Product> save(@RequestBody Product product) {
    public ResponseEntity<Producto> save(@RequestParam("picture") MultipartFile picture,
                                        @RequestParam("name") String name,
                                        @RequestParam("unit_price") int unit_price,
                                        @RequestParam("cantidad") int stock,
                                        @RequestParam("categoryId") Long categoryID )throws IOException{

        Producto product = new Producto();
        product.setName(name);
        product.setUnit_price(unit_price);
        product.setStock(stock);
        product.setPicture(Util.compressZLib(picture.getBytes()));

        //TODO: búsqueda de categoría para establecer en el objeto del producto
        //Agricultor agricultor = agricultorRepository.findById(agricultorID)
        //        .orElseThrow(()-> new ResourceNotFoundException("Not found agricultor with id="+agricultorID));

        //if( agricultor!=null) {
        //    product.setAgricultor(agricultor);
        //}

        CategoriaProducto categoriaProducto = categoriaRepository.findById(categoryID)
                .orElseThrow(()-> new ResourceNotFoundException("Not found category with id="+categoryID));

        if( categoriaProducto!=null) {
            product.setCategoriaProducto(categoriaProducto);
        }

        Producto productSaved=productoRepository.save(product);

        return new ResponseEntity<Producto>(productSaved,HttpStatus.CREATED);
    }

    //Exportar a excel file
    @GetMapping("/products/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_product";
        response.setHeader(headerKey, headerValue);

        List<Producto> products = productoRepository.findAll();

        ProductoExcelExporter excelExporter = new ProductoExcelExporter(
                products);

        excelExporter.export(response);
    }

    @Transactional
    @PutMapping("/products/{id}")
    public ResponseEntity<Producto> updateProduct(@PathVariable("id") Long id, @RequestBody Producto producto) {
        Producto productosUpdate = productoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));
        productosUpdate.setName(producto.getName());
        productosUpdate.setUnit_price(producto.getUnit_price());
        productosUpdate.setStock(producto.getStock());

        return new ResponseEntity<Producto>(productoRepository.save(productosUpdate),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    @GetMapping("/products/agricultor/{id}")
    public ResponseEntity<List<Producto>> findByAllProductsAgricultorIdSQL(@PathVariable("id") Long id){
        List<Producto> products = productoRepository.findByAllProductsAgricultorIdSQL(id);
        if(products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id){
        productoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
