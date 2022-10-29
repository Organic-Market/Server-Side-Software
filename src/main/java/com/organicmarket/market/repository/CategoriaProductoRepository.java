package com.organicmarket.market.repository;

import com.organicmarket.market.entities.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaProductoRepository
    extends JpaRepository<CategoriaProducto, Long> {
    //FILTRAR PRODUCTOS QUE SEAN ORGANICOS
    List<CategoriaProducto> findByNameContaining(String name);
    @Query(value = "SELECT p FROM CategoriaProducto p WHERE p.name LIKE %:organic%")
    List<CategoriaProducto> findByNameLike(String organic);

}


