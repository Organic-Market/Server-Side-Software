package com.organicmarket.market.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "mayorista_id", nullable = false)
    private Mayorista mayorista;

    @OneToMany(mappedBy = "pedido", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY)
    private Set<DetallePedido> detallePedidos = new HashSet<DetallePedido>();

    public Pedido() {
    }

    public Pedido(Date date, Mayorista mayorista) {
        this.date = date;
        this.mayorista = mayorista;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public Mayorista getMayorista() {
        return mayorista;
    }

    public void setMayorista(Mayorista mayorista) {
        this.mayorista = mayorista;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDetallePedidos(Set<DetallePedido> pedidos) {
        this.detallePedidos = pedidos;
    }

    public void addDetallePedido(DetallePedido detallePedido){
        this.detallePedidos.add(detallePedido);
    }

}
