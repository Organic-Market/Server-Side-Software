package com.organicmarket.market.entities;

import com.organicmarket.market.repository.CategoriaProductoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 20)
    private String name;
    @Column(name = "unit_price")
    private Double unit_price;
    @Column(name = "units_in_stock", nullable = false)
    private Short stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "agricultor_id")
    private Agricultor agricultor;

}
