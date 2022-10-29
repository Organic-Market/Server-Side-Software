package com.organicmarket.market.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "unit_price", nullable = false)
    private float unit_price;
    @Column(name = "stock", nullable = false)
    private int stock;

    @ManyToOne
    @JoinColumn(name = "agricultor_id", nullable = false)
    private Agricultor agricultor;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaProducto categoriaProducto;

    public Producto() {
    }

    public Producto(String name, float unit_price, int stock, CategoriaProducto categoriaProducto) {
        this.name = name;
        this.unit_price = unit_price;
        this.stock = stock;
        this.categoriaProducto = categoriaProducto;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                ", stock=" + stock +
                ", categoriaProducto=" + categoriaProducto +
                '}';
    }
}

