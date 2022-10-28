package com.organicmarket.market.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "unit_price")
    private float unit_price;
    @Column(name = "units_in_stock", nullable = false)
    private float stock;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CategoriaProducto CategoriaProducto;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Agricultor Agricultor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public com.organicmarket.market.entities.CategoriaProducto getCategoriaProducto() {
        return CategoriaProducto;
    }

    public void setCategoriaProducto(com.organicmarket.market.entities.CategoriaProducto categoriaProducto) {
        CategoriaProducto = categoriaProducto;
    }

    public com.organicmarket.market.entities.Agricultor getAgricultor() {
        return Agricultor;
    }

    public void setAgricultor(com.organicmarket.market.entities.Agricultor agricultor) {
        Agricultor = agricultor;
    }
}
