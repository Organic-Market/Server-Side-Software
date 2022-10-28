package com.organicmarket.market.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.*;


@Entity
@Table(name ="detalles_pedidos")
/*@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.producto",
                joinColumns = @JoinColumn(name = "producto_id")),
        @AssociationOverride(name = "primaryKey.pedido",
            joinColumns = @JoinColumn(name = "pedido_id"))
})*/
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private ProductoPedidoId primaryKey = new ProductoPedidoId();


    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;
    @Column(name = "discount", nullable = false)
    private float discount;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
