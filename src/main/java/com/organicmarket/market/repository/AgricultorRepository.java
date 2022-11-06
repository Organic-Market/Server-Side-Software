package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository
    extends JpaRepository<Agricultor, Long> {

    Agricultor findByUsername(String username);

}
