package com.iesjuanbosco.ejemploweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name="productos") //indica que la tabla en la base de datps relacionada con esta entidad
public class Producto {
    @Id     //Esta anotacion especifica que este campo va ser la clave principal de la tabla de en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //esta anotacion especifica que la clave primaria sea "auto-increment"
    private Long id;
    private String titulo;
    private Integer cantidad;
    private double precio;

    public Producto(Long id, String titulo, Integer cantidad, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }
}
