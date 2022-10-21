package com.organicmarket.market.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Embeddable
public class ProductoPedidoId implements Serializable {
    @JoinColumn(name = "producto_id")
    private Long idProducto;
    @JoinColumn(name = "pedido_id")
    private Long idPedido;
}
