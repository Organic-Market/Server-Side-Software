package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

}
