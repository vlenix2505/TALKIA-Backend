package com.upc.products.services;
import com.upc.products.entities.Proveedor;

import java.util.List;

public interface ProveedorService {
    public Proveedor insertar(Proveedor proveedor);
    public Proveedor editar(Proveedor proveedor);
    public void eliminar(long id);
    public List<Proveedor> listar();
    public Proveedor buscarPorId(long id);
}
