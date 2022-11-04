package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Pedido;
import com.organicmarket.market.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> getAllPedido() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return new ResponseEntity<List<Pedido>>(pedido, HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido newPedido =
                pedidoRepository.save(
                        new Pedido(pedido.getDate(),
                                pedido.getMayorista()));
        return new ResponseEntity<Pedido>(newPedido, HttpStatus.CREATED);
    }
    @Transactional
    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<HttpStatus> deletePedido(@PathVariable("id") Long id){
        pedidoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
