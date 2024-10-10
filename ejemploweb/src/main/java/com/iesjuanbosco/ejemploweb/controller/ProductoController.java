package com.iesjuanbosco.ejemploweb.controller;

import com.iesjuanbosco.ejemploweb.entity.Producto;
import com.iesjuanbosco.ejemploweb.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/productos2")
    @ResponseBody

    public String index(){
        List<Producto> productos = this.productoRepository.findAll();
        String HTML = new stringBuilder("<html><body>");
        productos.forEach(producto -> {
            HTML=append("<p>" + producto.getTitulo() + "<p>");
        });
        HTML += "</body></html";
        return HTML;

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
