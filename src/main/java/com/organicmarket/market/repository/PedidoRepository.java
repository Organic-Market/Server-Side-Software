package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {

    @Query("FROM Pedido p WHERE p.mayorista.username = :username OR LOWER(p.mayorista.name) LIKE %:fullname% OR LOWER(p.mayorista.lastname) LIKE %:fullname%")
    List<Pedido> search(@Param("username") String username, @Param("fullname") String fullname);

    @Query("FROM Pedido p WHERE p.date BETWEEN :date1 AND :date2")
    List<Pedido> searchByDate(@Param("date1") LocalDateTime date1, @Param("date2") LocalDateTime date2);

    @Query(value="select * from fn_reporte_cantidad_pedidos_fecha()", nativeQuery = true)
    List<Object[]> callProcedureorFunction();


}
