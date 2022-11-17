package com.organicmarket.market.controller;

import com.organicmarket.market.Util.CategoriaExcelExporter;
import com.organicmarket.market.entities.CategoriaProducto;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.CategoriaProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
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

    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaProducto> searchCategoriesById(@PathVariable Long id) {
        CategoriaProducto categoriaProducto= categoriaProductoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found category with id="+id));
        return new ResponseEntity<CategoriaProducto>(categoriaProducto,HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/categoria")
    public ResponseEntity<CategoriaProducto> save(@RequestBody CategoriaProducto categoriaProducto){
        CategoriaProducto newCategoriaProducto = CategoriaProducto.builder().name(categoriaProducto.getName()).build();
        categoriaProductoRepository.save(newCategoriaProducto);
        return new ResponseEntity<CategoriaProducto>(newCategoriaProducto, HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/categoria/{id}")
    public ResponseEntity<CategoriaProducto> update(@RequestBody CategoriaProducto categoriaProducto, @PathVariable Long id) {
        CategoriaProducto categoriaProductoUpdate= categoriaProductoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found category with id="+id));

        categoriaProductoUpdate.setName(categoriaProducto.getName());

        return new ResponseEntity<CategoriaProducto>(categoriaProductoRepository.save(categoriaProductoUpdate),
                HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") Long id){
        categoriaProductoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/categoria/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_category";
        response.setHeader(headerKey, headerValue);

        List<CategoriaProducto> categoryResponse = categoriaProductoRepository.findAll();

        CategoriaExcelExporter excelExporter = new CategoriaExcelExporter(
                categoryResponse);

        excelExporter.export(response);
    }

}
