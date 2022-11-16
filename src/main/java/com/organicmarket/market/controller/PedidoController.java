package com.organicmarket.market.controller;

import com.organicmarket.market.dto.PedidoProcDTO;
import com.organicmarket.market.entities.Pedido;
import com.organicmarket.market.repository.PedidoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@Controller
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> serachPedidos() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
    @Transactional
    @PostMapping("/pedido")
    public ResponseEntity<Pedido> savePedido(@RequestBody Pedido pedido) {
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

    @GetMapping("/pedido/search/date")
    public ResponseEntity<List<Pedido>> searchByDate(@RequestParam(value = "date1") String date1, @RequestParam(value = "date2") String date2){
        List<Pedido> pedidos =pedidoRepository.searchByDate(
                LocalDateTime.parse(date1), LocalDateTime.parse(date2));
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/pedido/search/others")
    public ResponseEntity<List<Pedido>> searchByOthers(@RequestParam(value = "username") String username, @RequestParam(value = "fullname") String fullName){
        List<Pedido> pedidos = pedidoRepository.search(username,fullName);

        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> save(@Valid @RequestBody Pedido pedido) {
        pedido.getDetallePedidos().forEach(det -> det.setPedido(pedido));
        Pedido newPedido=pedidoRepository.save(pedido);
        return new ResponseEntity<Pedido>(newPedido,HttpStatus.CREATED);
    }

    @GetMapping("/pedidos/callProcedure")
    public ResponseEntity<List<PedidoProcDTO>> callProcOrFunction(){
        List<PedidoProcDTO> pedidos = new ArrayList<>();
        pedidoRepository.callProcedureorFunction().forEach(x -> {
            PedidoProcDTO dto = new PedidoProcDTO();
            dto.setQuantity((Integer) x[0]);
            dto.setConsultdate((String) x[1]);
            pedidos.add(dto);
        });
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }
}
