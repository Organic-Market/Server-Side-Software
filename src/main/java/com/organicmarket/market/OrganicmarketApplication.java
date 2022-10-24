package com.organicmarket.market;

import com.organicmarket.market.entities.Agricultor;
import com.organicmarket.market.entities.Producto;
import com.organicmarket.market.repository.AgricultorRepository;
import com.organicmarket.market.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OrganicmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrganicmarketApplication.class, args);
    }


}
