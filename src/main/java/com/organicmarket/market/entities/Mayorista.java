package com.organicmarket.market.entities;

import javax.persistence.*;

@Entity
public class Mayorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String address;
}
