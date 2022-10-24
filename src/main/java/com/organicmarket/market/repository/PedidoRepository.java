package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository
    extends JpaRepository<Pedido, Long> {
    //VISUALIZAR ULTIMOS PRODUCTOS VENDIDOS
    List<Pedido>findbyStartDate(String date);

}
