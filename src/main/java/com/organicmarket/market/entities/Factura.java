package com.organicmarket.market.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float price;
    private Date created;



}
