package com.organicmarket.market.entities;

import javax.persistence.*;

@Entity
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantity;
    private float subtotal;
    private float discount;

}
