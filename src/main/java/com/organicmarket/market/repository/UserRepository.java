package com.organicmarket.market.repository;

import com.organicmarket.market.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

}
