package cic.diplojava.webcompras.servisio;


import cic.diplojava.webcompras.modelo.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductosService {
    List<Producto> listaProductos();
    Optional<Producto> buscaProducto(Integer id);

}
