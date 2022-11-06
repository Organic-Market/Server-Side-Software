package com.organicmarket.market.repository;

import com.organicmarket.market.entities.CategoriaProducto;
import com.organicmarket.market.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

    //SQL
    @Query(value = "select a.id, a.name, p.name, p.stock, p.unit_price from products p join agricultor a on a.id = p.agricultor_id where a.id=?1", nativeQuery = true)
    List<Producto> findByAllProductsAgricultorIdSQL(Long id);
    //JPQL
    @Query(value = "SELECT a.id, a.name, p.name, p.stock, p.unit_price FROM Producto p JOIN p.agricultor a ON a.id = p.agricultor.id WHERE a.id=?1")
    List<Producto> findByAllProductsAgricultorIdJPQL(Long id);

    @Query(value = "SELECT * FROM products WHERE name like %:name%", nativeQuery = true)
    List<Producto> findProductsByName(@Param("name") String name);


}
