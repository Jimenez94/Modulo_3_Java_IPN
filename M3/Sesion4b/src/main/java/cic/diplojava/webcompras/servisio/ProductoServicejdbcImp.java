package cic.diplojava.webcompras.servisio;

import cic.diplojava.webcompras.modelo.Producto;
import cic.diplojava.webcompras.respository.ProductoRepositoryJdbcImp;
import cic.diplojava.webcompras.respository.Repository;
import cic.diplojava.webcompras.servisio.exception.ServicioJdbcException;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductoServicejdbcImp implements ProductosService {

    private Repository<Producto> repo;

    public ProductoServicejdbcImp(Connection conexion) {
        repo = new ProductoRepositoryJdbcImp(conexion);
    }

    @Override
    public List<Producto> listaProductos() {
        try {
            return repo.listar();
        } catch (SQLException e) {
            throw new ServicioJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> buscaProducto(Integer id) {
        try {
            return Optional.ofNullable((Producto) repo.porId(id));
        } catch (SQLException e) {
            throw new ServicioJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repo.guardar(producto);
        } catch (SQLException e) {
            throw new ServicioJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            repo.eliminar(id);
        } catch (SQLException e) {
            throw new ServicioJdbcException(e.getMessage(), e.getCause());
        }
    }
}
