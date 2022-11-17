package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgricultorRepository
    extends JpaRepository<Agricultor, Long> {

    Agricultor findByUsername(String username);

    Optional<Agricultor> findByEmailAndPassword(String email, String password);

}
