package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    //Actualizar el estado de la oferta del producto orgánico = Update

    //Promocionar cultivos orgánicos = post
}
