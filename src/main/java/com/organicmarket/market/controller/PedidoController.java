package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Pedido;
import com.organicmarket.market.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido newPedido =
                pedidoRepository.save(
                        new Pedido(pedido.getDate()));
        return new ResponseEntity<Pedido>(newPedido, HttpStatus.CREATED);
    }

}
