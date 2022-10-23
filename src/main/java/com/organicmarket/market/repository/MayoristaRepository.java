package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MayoristaRepository
    extends JpaRepository<Mayorista, Long> {


    // US = Acceder a información confiable de los compradores interesados = Select

    List<Mayorista> findByNameAndLastName(String name, String lastName);
    List<Mayorista> findByPedidos(Pedido pedidos);


}
