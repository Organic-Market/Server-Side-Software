package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Mayorista;
import com.organicmarket.market.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MayoristaRepository
    extends JpaRepository<Mayorista, Long> {


    @Query(value = "Select distinct m.id, m.name, m.last_name, m.address from mayorista m join mayorista_pedidos mp on m.id = mp.mayorista_id join pedidos pe on pe.id = mp.pedidos_id join detalle_pedido dp on pe.id = dp.pedido_id join products pr on dp.producto_id = pr.id join agricultor_products ap on pr.id = ap.products_id join agricultor a on ap.agricultor_id = a.id where a.id =?1", nativeQuery = true)
    List<Mayorista> findByAllCompradoresAgricultorIdSQL(Long id);


}
