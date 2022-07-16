package cic.diplojava.webcompras.respository;

import cic.diplojava.webcompras.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductoRepositoryJdbcImp implements Repository<Producto> {

    private Connection conexion;

    public ProductoRepositoryJdbcImp(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sentencia = "SELECT * FROM producto AS p ORDER BY p ORDER BY p.id ASC";
        try (Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery(sentencia)) {
            while (rs.next()) {
                Producto p = getProduucto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Integer id) throws SQLException {
        Producto producto = null;
        String query = "SELECT * FROM producto AS p WHERE p.id = ?";
        try (PreparedStatement pstm = conexion.prepareStatement(query)) {
            pstm.setInt(1, id);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    producto = getProduucto(rs);
                }
            }
        }
        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }

    private Producto getProduucto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getInt("id"));
        p.setNombre((rs.getString("nombre")));
        p.setDescripcion(rs.getString("descripcion"));
        p.setPrecio(rs.getFloat("precio"));
        return p;
    }
}
