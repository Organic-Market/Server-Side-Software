package com.organicmarket.market.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name="products")
public class Producto {

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

    private Set<DetallePedido> detallePedidos = new HashSet<DetallePedido>();

    public Producto() {
    }

    public Producto(String name, float unit_price, float stock) {
        this.name = name;
        this.unit_price = unit_price;
        this.stock = stock;
    }

    public void addProducto(DetallePedido pedido) {
        this.detallePedidos.add(pedido);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @OneToMany(mappedBy = "primaryKey.producto",
        cascade = CascadeType.ALL)
    public Set<DetallePedido> getDetallePedidos() {
        return detallePedidos;
    }

    public void setDetallePedidos(Set<DetallePedido> pedidos) {
        this.detallePedidos = pedidos;
    }

    public void addDetallePedido(DetallePedido detallePedido){
        this.detallePedidos.add(detallePedido);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit_price=" + unit_price +
                ", stock=" + stock +
                ", CategoriaProducto=" + CategoriaProducto +
                ", Agricultor=" + Agricultor +
                '}';
    }
}
