package com.organicmarket.market.entities;

import com.organicmarket.market.repository.CategoriaProductoRepository;

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
    private Double unit_price;
    @Column(name = "units_in_stock", nullable = false)
    private Short stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "agricultor_id")
    private Agricultor agricultor;

    public Producto() {
    }
    public Producto(String name, Double unit_price, Short stock) {
        this.name = name;
        this.unit_price = unit_price;
        this.stock = stock;
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

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                ", stock=" + stock +
                '}';
    }
}
