package com.organicmarket.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
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
