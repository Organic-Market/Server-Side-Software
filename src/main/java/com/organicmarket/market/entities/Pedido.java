package com.organicmarket.market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "mayorista_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PEDIDO_MAYORISTA"))
    private Mayorista mayorista;

    @OneToMany(mappedBy = "pedido",
            cascade = { CascadeType.ALL }, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<DetallePedido> detallePedidos;


}
