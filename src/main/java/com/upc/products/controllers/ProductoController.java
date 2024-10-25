package com.upc.products.controllers;

import com.upc.products.dtos.ProductoDTO;
import com.upc.products.dtos.ProveedorDTO;
import com.upc.products.entities.Producto;
import com.upc.products.entities.Proveedor;
import com.upc.products.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping("/producto")
    public ResponseEntity<Producto> adicionarProducto(@RequestBody Producto producto) {
        Producto productoRe = productoService.insertarProducto(producto);
        return  new ResponseEntity<>(productoRe, HttpStatus.OK);
    }

    @GetMapping("/productos")
    public List<ProductoDTO> listaProductos() {
        List<Producto> productos = productoService.listarProductos();
        ModelMapper modelMapper = new ModelMapper();
        return productos.stream()
                .map(producto -> modelMapper.map(producto, ProductoDTO.class))
                .collect(Collectors.toList());
    }

}
