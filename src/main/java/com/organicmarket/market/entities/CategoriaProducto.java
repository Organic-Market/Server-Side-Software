package com.organicmarket.market.entities;

import javax.persistence.*;

@Entity
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 20)
    private String name;

    public CategoriaProducto() {
    }

    public CategoriaProducto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoriaProducto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
