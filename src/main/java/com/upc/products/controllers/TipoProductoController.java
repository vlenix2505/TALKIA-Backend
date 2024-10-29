package com.upc.products.controllers;

import com.upc.products.dtos.ProveedorDTO;
import com.upc.products.dtos.TipoProductoDTO;
import com.upc.products.entities.Proveedor;
import com.upc.products.entities.TipoProducto;
import com.upc.products.services.TipoProductoService;
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
public class TipoProductoController {
    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping("/tipoProductos")
    public List<TipoProductoDTO> listaTiposProductos() {
        List<TipoProducto> tipos = tipoProductoService.listarTipoProductos();
        ModelMapper modelMapper = new ModelMapper();
        return tipos.stream()
                .map(tipo -> modelMapper.map(tipo, TipoProductoDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping("/tipoProducto")//add
    public ResponseEntity<TipoProductoDTO> adicionaTipo(@RequestBody TipoProductoDTO tipoProductoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        TipoProducto tipoProducto = modelMapper.map(tipoProductoDTO, TipoProducto.class);
        tipoProducto = tipoProductoService.insertarTipoProducto(tipoProducto);
        tipoProductoDTO = modelMapper.map(tipoProducto, TipoProductoDTO.class);
        return ResponseEntity.ok(tipoProductoDTO);
    }
}
