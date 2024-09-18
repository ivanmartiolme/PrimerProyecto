package com.iesjuanbosco.ejemploweb.controller;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import com.iesjuanbosco.ejemploweb.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

// para que spring sepa que esta clase es un controlasoe tenemos que añadir la anotacion @Controller antes de la clase
@Controller //anotacion que indica a spring que esta clase es un controlador

public class ProductoController {
    //para acceder al repositorio creamos una propiedad y la asignamos en el constructor
    private ProductoRepository productoRepository;

    public ProductoController(ProductoRepository repository) {
        this.productoRepository = repository;
    }

    /* con la notacion GetMapping le indicamos a Spring que el siguiente metodo
        se va a ejecutar cuando el usuario acceda a la url GET http://localhost/productos*/
    @GetMapping("/productos")
    public String findAll(){
        List<Producto> productos = this.productoRepository.findAll();
        return "producto-list";

    }

    @GetMapping("/productos/add")
    public String add(){
        List<Producto> productos = new ArrayList<Producto>();
        Producto p1 = new Producto(null,"producto 1", 20,45.5);
        Producto p2 = new Producto(null,"producto 2", 40,5.5);
        Producto p3 = new Producto(null,"producto 3", 30,105.5);
        Producto p4 = new Producto(null,"producto 4", 10,400.5);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);

        //guardamos todos los productos en la base de datos utilizando el objeto productoRepository
        this.productoRepository.saveAll(productos);
        return "redirect:/productos";
    }

}
