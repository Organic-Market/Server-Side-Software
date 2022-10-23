package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    //Actualizar el estado de la oferta del producto orgánico = Update

    //Promocionar cultivos orgánicos = post

    //Acceder a información de los producto - DIEGO
           List<Producto>findAll();

}
