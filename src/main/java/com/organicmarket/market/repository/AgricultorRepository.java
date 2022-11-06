package com.organicmarket.market.repository;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.Mayorista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgricultorRepository
<<<<<<< Updated upstream
    extends JpaRepository<Agricultor, Long> {


=======
        extends JpaRepository<Agricultor, Long> {
    Agricultor findByUsername(String username);
>>>>>>> Stashed changes
}
