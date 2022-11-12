package com.organicmarket.market.entities;


import javax.persistence.CascadeType;
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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column( name ="picture")
    private byte[] picture;

    @ManyToOne
    @JoinColumn(name = "agricultor_id", nullable = true)
    private Agricultor agricultor;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = true)
    private CategoriaProducto categoriaProducto;

    public Producto() {
    }

    public Producto(String name, float unit_price, int stock, byte[] picture, Agricultor agricultor, CategoriaProducto categoriaProducto) {
        this.name = name;
        this.unit_price = unit_price;
        this.stock = stock;
        this.picture = picture;
        this.agricultor = agricultor;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Agricultor getAgricultor() {
        return agricultor;
    }

    public void setAgricultor(Agricultor agricultor) {
        this.agricultor = agricultor;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }
}

