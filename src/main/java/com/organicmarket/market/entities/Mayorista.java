package com.organicmarket.market.entities;

import javax.persistence.*;

@Entity
@Table(name = "mayorista")
public class Mayorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;
    @Column(name = "lastname", length = 30, nullable = false)
    private String lastname;
    @Column(name ="address", length = 60, nullable = false)
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;



    public Mayorista() {
    }

    public Mayorista(String name, String lastname, String address, User user) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.user = user;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}