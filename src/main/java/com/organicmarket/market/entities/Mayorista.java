package com.organicmarket.market.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Mayorista")
public class Mayorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 15, nullable = false)
    private String name;
<<<<<<< Updated upstream
    @Column(name = "lastName", length = 30, nullable = false)
    private String lastName;
=======

    @Column(name = "lastname", length = 30, nullable = false)
    private String lastname;

>>>>>>> Stashed changes
    @Column(name ="address", length = 60, nullable = false)
    private String address;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

<<<<<<< Updated upstream
    public Mayorista() {
    }

    public Mayorista(String name, String lastName, String address) {
=======
    @Column(name = "email", nullable = false)
    private String email;

    public Mayorista() {
    }

    public Mayorista(String name, String lastname, String address, String username, String password, String email) {
>>>>>>> Stashed changes
        this.name = name;
        this.lastName = lastName;
        this.address = address;
<<<<<<< Updated upstream
=======
        this.username = username;
        this.password = password;
        this.email = email;
>>>>>>> Stashed changes
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

<<<<<<< Updated upstream
    @Override
    public String toString() {
        return "Mayorista{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
=======
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
>>>>>>> Stashed changes
    }
}
