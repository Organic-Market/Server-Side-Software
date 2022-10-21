package com.organicmarket.market.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price", nullable = false)
    private float price;

    public Factura() {
    }

    public Factura(float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
}
