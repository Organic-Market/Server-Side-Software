package com.organicmarket.market.repository;

import com.organicmarket.market.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository
    extends JpaRepository<User, Long> {

}
