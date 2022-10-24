package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {


    //Actualizar el estado de la oferta del producto orgánico = Update

    //Promocionar cultivos orgánicos = post

    //Acceder a información de los producto - DIEGO
           List<Producto>findAll();

    @Query(value = "select a.id, a.name, p.name, p.stock, p.unit_price from agricultor a join agricultor_products ap on a.id = ap.agricultor_id join products p on ap.products_id = p.id where a.id =?1", nativeQuery = true)
    List<Producto> findByAllProductsAgricultorIdSQL(Long id);

}
