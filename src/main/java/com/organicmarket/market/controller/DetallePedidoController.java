package com.organicmarket.market.controller;

import com.organicmarket.market.entities.DetallePedido;
import com.organicmarket.market.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional(readOnly = true)
    @GetMapping("/detalle_pedido")
    public ResponseEntity<List<DetallePedido>> searchDetallePedido(){
        List<DetallePedido> detallePedido = detallePedidoRepository.findAll();
        return new ResponseEntity<List<DetallePedido>>(detallePedido, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/detalle_pedido")
    public ResponseEntity<DetallePedido> saveDetallePedido(@RequestBody DetallePedido detalle_pedido){
        DetallePedido newdetallePedido =
                detallePedidoRepository.save(
                        new DetallePedido(detalle_pedido.getQuantity(),
                                detalle_pedido.getPrice(),
                                detalle_pedido.getDiscount(),
                                detalle_pedido.getPedido(),
                                detalle_pedido.getProducto())
                );
        return new ResponseEntity<DetallePedido>(newdetallePedido, HttpStatus.CREATED);
    }
}
