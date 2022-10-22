package com.organicmarket.market.entities;


import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.*;


@Entity
@Table(name ="DetallePedido")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.producto",
                joinColumns = @JoinColumn(name = "producto_id")),
        @AssociationOverride(name = "primaryKey.pedido",
            joinColumns = @JoinColumn(name = "pedido_id"))
})
public class DetallePedido {

    private ProductoPedidoId primaryKey = new ProductoPedidoId();


    @Column(name = "quantity", nullable = false)
    private Short quantity;

    @Column(name = "unit_price", nullable = false)
    private float unitPrice;
    @Column(name = "discount", nullable = false)
    private float discount;

    @EmbeddedId
    public ProductoPedidoId getPrimaryKey(){
        return primaryKey;
    }

    public void setPrimaryKey(ProductoPedidoId primaryKey){
        this.primaryKey = primaryKey;
    }

    @Transient
    public Pedido getPedido(){
        return getPrimaryKey().getPedido();
    }

    public void setPedido(Pedido pedido){
        getPrimaryKey().setPedido(pedido);
    }

    @Transient
    public Producto getProducto(){
        return getPrimaryKey().getProducto();
    }

    public void setProducto(Producto producto){
        getPrimaryKey().setProducto(producto);
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
}
