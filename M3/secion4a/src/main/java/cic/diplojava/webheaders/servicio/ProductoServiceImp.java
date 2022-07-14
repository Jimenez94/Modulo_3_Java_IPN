package cic.diplojava.webheaders.servicio;

import cic.diplojava.webheaders.modelo.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImp implements ProductosService{
    @Override
    public List<Producto> listaProductos() {
        return Arrays.asList(new Producto(1,"Coca-cola","Refresco con gas",18.5f),
                new Producto(2,"Mantecadas","Pan orneado", 15.50f),
                new Producto(3,"Gansito","Pan orneado",15.0f));
    }
}
