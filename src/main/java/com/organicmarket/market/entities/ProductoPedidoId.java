package com.organicmarket.market.entities;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class ProductoPedidoId implements Serializable {
   private Producto producto;

   private Pedido pedido;

   @ManyToOne(cascade = CascadeType.ALL)
    public Producto getProducto() {
       return producto;
   }

   public void setProducto(Producto producto) {
       this.producto = producto;
   }

   @ManyToOne(cascade = CascadeType.ALL)
    public Pedido getPedido() {
       return pedido;
   }
   public void setPedido(Pedido pedido) {
       this.pedido = pedido;
   }
}
