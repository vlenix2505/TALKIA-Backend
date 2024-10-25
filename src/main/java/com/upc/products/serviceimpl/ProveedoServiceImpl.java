package com.upc.products.serviceimpl;

import com.upc.products.entities.Proveedor;
import com.upc.products.repositories.ProveedorRepositorio;
import com.upc.products.services.ProveedorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProveedoServiceImpl implements ProveedorService {
    @Autowired
    private ProveedorRepositorio proveedorRepositorio;
    @Override
    public Proveedor insertar(Proveedor proveedor) {
        return proveedorRepositorio.save(proveedor);
    }

    @Override
    public Proveedor editar(Proveedor proveedor) {
        if (proveedorRepositorio.findById(proveedor.getIdProveedor()).isPresent()){
            return proveedorRepositorio.save(proveedor);
        }
        return null;
    }

    @Override
    @Transactional
    public void eliminar(long id) {
        if(proveedorRepositorio.findById(id).isPresent()){
            proveedorRepositorio.deleteById(id);
        }
    }

    @Override
    public List<Proveedor> listar() {
        return proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor buscarPorId(long id) {
        if(proveedorRepositorio.findById(id).isPresent()){
            return proveedorRepositorio.findById(id).get();
        }
        return null;
    }
}
