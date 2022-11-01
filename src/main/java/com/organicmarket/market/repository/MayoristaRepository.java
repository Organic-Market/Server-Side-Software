package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Mayorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MayoristaRepository
        extends JpaRepository<Mayorista, Long> {

    @Query(value ="Select distinct m.name, m.lastname, m.address from mayorista m join pedidos pe on m.id = pe.mayorista_id join detalles_pedidos dp on pe.id = dp.pedido_id join products pr on dp.producto_id = pr.id join agricultor a on pr.agricultor_id = a.id where a.id=?1", nativeQuery = true)
    List<Mayorista> findByAllCompradoresAgricultorIdSQL(Long id);
}
