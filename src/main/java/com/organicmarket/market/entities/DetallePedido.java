package com.organicmarket.market.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detalles_pedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false,
        foreignKey=@ForeignKey(name="FK_PEDIDO_DETALLE"))
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}
