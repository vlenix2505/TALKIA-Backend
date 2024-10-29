package com.upc.products.controllers;

import com.upc.products.dtos.ProveedorDTO;
import com.upc.products.entities.Proveedor;
import com.upc.products.services.ProveedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/proveedores")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ProveedorDTO> listaProveedores() {
        List<Proveedor> proveedores = proveedorService.listar();
        ModelMapper modelMapper = new ModelMapper();
        return proveedores.stream()
                .map(proveedor -> modelMapper.map(proveedor, ProveedorDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping("/proveedor")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProveedorDTO> adicionaProveedor(@RequestBody ProveedorDTO proveedorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedor = proveedorService.insertar(proveedor);
        proveedorDTO = modelMapper.map(proveedor, ProveedorDTO.class);
        return ResponseEntity.ok(proveedorDTO);
    }
    @PutMapping("/proveedor")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProveedorDTO>  editarCliente(@RequestBody ProveedorDTO proveedorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Proveedor proveedor = modelMapper.map(proveedorDTO, Proveedor.class);
        proveedor = proveedorService.editar(proveedor);
        proveedorDTO = modelMapper.map(proveedor, ProveedorDTO.class);
        return ResponseEntity.ok(proveedorDTO);
    }
    @DeleteMapping("/proveedor/{id}")
    @PreAuthorize("hasRole('GERENTE')")
    public void eliminarProveedor(@PathVariable int id) {
        proveedorService.eliminar(id);
    }
    @GetMapping("/proveedor/{id}")
    public ResponseEntity<ProveedorDTO> buscaProveedor(@PathVariable int id) {
        ModelMapper modelMapper = new ModelMapper();
        Proveedor proveedor = proveedorService.buscarPorId(id);
        ProveedorDTO proveedorDTO = modelMapper.map(proveedor, ProveedorDTO.class);
        return ResponseEntity.ok(proveedorDTO);
    }
}
