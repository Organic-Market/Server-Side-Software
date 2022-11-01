package com.organicmarket.market.repository;

import com.organicmarket.market.entities.CategoriaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaProductoRepository
    extends JpaRepository<CategoriaProducto, Long> {
    //Filtrar busqueda de productos organicos ofertados
    List<CategoriaProducto> findByNameContaining(String name);
    @Query(value = "SELECT cp FROM CategoriaProducto cp WHERE cp.name like %:name%")
    List<CategoriaProducto> findByNameLikeJPQL(@Param("name") String name);

    @Query(value = "SELECT * FROM categoria_producto WHERE name like %:name%", nativeQuery = true)
    List<CategoriaProducto> findByNameLikeSQL(@Param("name") String name);


}


