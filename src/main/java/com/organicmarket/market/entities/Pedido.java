package com.organicmarket.market.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;

@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "mayorista_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDO_MAYORISTA"))
    private Mayorista mayorista;

    @OneToMany(mappedBy = "pedido",
            cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetallePedido> detallePedidos;

    public Pedido() {
    }

    public Pedido(LocalDateTime date, Mayorista mayorista) {
        this.date = date;
        this.mayorista = mayorista;
    }

    /*public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Mayorista getMayorista() {
        return mayorista;
    }


    public void setDetallePedidos(List<DetallePedido> pedidos) {
        this.detallePedidos = pedidos;
    }

    public void addDetallePedido(DetallePedido detallePedido){
        this.detallePedidos.add(detallePedido);
    }

    /*@Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", date=" + date +
                ", mayorista=" + mayorista +
                '}';*/
}
