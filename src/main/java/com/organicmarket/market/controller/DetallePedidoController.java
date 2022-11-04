package com.organicmarket.market.controller;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.DetallePedido;
import com.organicmarket.market.exception.ResourceNotFoundException;
import com.organicmarket.market.repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @GetMapping("/detalle_pedido")
    public ResponseEntity<List<DetallePedido>> getAllDetallePedido(){
        List<DetallePedido> detallePedido = detallePedidoRepository.findAll();
        return new ResponseEntity<List<DetallePedido>>(detallePedido, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/detalle_pedido")
    public ResponseEntity<DetallePedido> createDetallePedido(@RequestBody DetallePedido detalle_pedido){
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
    @Transactional
    @PutMapping("/detalle_pedido/{id}")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable("id") Long id, @RequestBody DetallePedido detalle_pedido) {
        DetallePedido updateDetallePedido = detallePedidoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Not found products with id="+id));
        updateDetallePedido.setPrice(detalle_pedido.getPrice());
        updateDetallePedido.setDiscount(detalle_pedido.getDiscount());
        updateDetallePedido.setPedido(detalle_pedido.getPedido());
        updateDetallePedido.setProducto(detalle_pedido.getProducto());

        return new ResponseEntity<DetallePedido>(detallePedidoRepository.save(updateDetallePedido),
                HttpStatus.OK);
    }
    @Transactional
    @DeleteMapping("/detalle_pedido/{id}")
    public ResponseEntity<HttpStatus> deleteDetallePedido(@PathVariable("id") Long id){
        detallePedidoRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
