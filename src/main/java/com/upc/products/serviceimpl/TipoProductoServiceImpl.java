package com.upc.products.serviceimpl;

import com.upc.products.entities.TipoProducto;
import com.upc.products.repositories.TipoProductoRepositorio;
import com.upc.products.services.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {

    @Autowired
    private TipoProductoRepositorio tipoProductoRepositorio;

    @Override
    public TipoProducto insertarTipoProducto(TipoProducto producto) {
        return tipoProductoRepositorio.save(producto);
    }

    @Override
    public void eliminarTipoProducto(Long id) {
        if(tipoProductoRepositorio.existsById(id)) {
            tipoProductoRepositorio.deleteById(id);
        }
    }

    @Override
    public TipoProducto modificarTipoProducto(TipoProducto producto) {
        if(tipoProductoRepositorio.findById(producto.getId()).isPresent()) {
            return tipoProductoRepositorio.save(producto);
        }
        return null;
    }

    @Override
    public List<TipoProducto> listarTipoProductos() {
        return tipoProductoRepositorio.findAll();
    }

    @Override
    public TipoProducto buscarTipoProductoPorId(long id) {
        if(tipoProductoRepositorio.findById(id).isPresent()){
            return tipoProductoRepositorio.findById(id).get();
        }
        return null;
    }

}
