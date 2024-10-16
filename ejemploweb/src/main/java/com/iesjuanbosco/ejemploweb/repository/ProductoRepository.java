package com.iesjuanbosco.ejemploweb.repository;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //indica que esta clase es un repositorio
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
