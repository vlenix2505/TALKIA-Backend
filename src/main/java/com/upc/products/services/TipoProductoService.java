package com.upc.products.services;


import com.upc.products.entities.TipoProducto;

import java.util.List;

public interface TipoProductoService {
    public TipoProducto insertarTipoProducto(TipoProducto producto);
    public void eliminarTipoProducto(Long id);
    public TipoProducto modificarTipoProducto(TipoProducto producto);
    public List<TipoProducto> listarTipoProductos();
    public TipoProducto buscarTipoProductoPorId(long id);
}
