package cic.diplojava.webcompras.servisio;

import cic.diplojava.webcompras.modelo.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImp implements ProductosService{
    @Override
    public List<Producto> listaProductos() {
        return Arrays.asList(new Producto(1,"Coca-cola","Refresco con gas",18.5f),
                new Producto(2,"Mantecadas","Pan orneado", 15.50f),
                new Producto(3,"Gansito","Pan orneado",15.0f));
    }

    @Override
    public Optional<Producto> buscaProducto(Integer id) {
        return listaProductos().stream().filter(p -> p.getId().equals(id)).findAny();
    }
}
