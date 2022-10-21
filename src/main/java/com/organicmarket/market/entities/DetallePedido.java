package com.organicmarket.market.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="DetallePedido")
@AllArgsConstructor
@NoArgsConstructor
public class DetallePedido {
    @EmbeddedId
    private ProductoPedidoId productoPedidoId;


    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;
    @Column(name = "discount", nullable = false)
    private float discount;


}
