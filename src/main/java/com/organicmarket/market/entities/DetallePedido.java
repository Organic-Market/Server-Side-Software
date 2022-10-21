package com.organicmarket.market.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name ="DetallePedido")
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
