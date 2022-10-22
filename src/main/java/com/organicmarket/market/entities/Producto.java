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
    private Enum unit_price;
    @Column(name = "units_in_stock", nullable = false)
    private Short stock;

    @ManyToOne
    private CategoriaProducto CategoriaProducto;

    @ManyToOne
    private Agricultor Agricultor;

    private Set<DetallePedido> detallePedidos = new HashSet<DetallePedido>();

    public Producto() {
    }

    public Producto(String name, Enum unit_price, Short stock) {
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

    public Enum getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Enum unit_price) {
        this.unit_price = unit_price;
    }

    public Short getStock() {
        return stock;
    }

    public void setStock(Short stock) {
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
