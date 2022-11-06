package com.organicmarket.market.DTO;

public class CreateProducto {

    private String name;
    private int stock;
    private float unit_price;
    private Long agricultor_id;
    private Long categoria_id;

    public CreateProducto(String name, int stock, float unit_price, Long agricultor_id, Long categoria_id) {
        this.name = name;
        this.stock = stock;
        this.unit_price = unit_price;
        this.agricultor_id = agricultor_id;
        this.categoria_id = categoria_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public Long getAgricultor_id() {
        return agricultor_id;
    }

    public void setAgricultor_id(Long agricultor_id) {
        this.agricultor_id = agricultor_id;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }
}
