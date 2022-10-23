package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgricultorRepository
    extends JpaRepository<Agricultor, Long> {

    //Visualizar sus propios productos ofertados por parte del agricultor = Select


}
