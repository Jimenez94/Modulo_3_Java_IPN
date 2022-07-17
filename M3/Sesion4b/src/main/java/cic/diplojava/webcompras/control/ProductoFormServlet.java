package cic.diplojava.webcompras.control;

import cic.diplojava.webcompras.modelo.Producto;
import cic.diplojava.webcompras.servisio.ProductoServicejdbcImp;
import cic.diplojava.webcompras.servisio.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/productos/form")
public class ProductoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/formulario.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = (Connection) req.getAttribute("conexion");
        ProductosService productosService = new ProductoServicejdbcImp(connection);
        String nombre = (String) req.getParameter("nombre");
        String descripcion = (String) req.getParameter("descripcion");
        float precio;
        try {
            precio = Float.parseFloat(req.getParameter("precio"));
        } catch (NumberFormatException e) {
            precio = 0.0f;
        }
        Map<String, String> errores = new HashMap<>();
        if (nombre == null || nombre.isBlank()) {
            errores.put("nombre", "Nombre es requerido");
        } else if (nombre.length() > 45) {
            errores.put("nombre", "Nombre mayor de 45 caracteres");
        }
        if (descripcion == null || descripcion.isBlank()) {
            errores.put("descripcion", "descripcion es requerido");
        } else if (descripcion.length() > 45) {
            errores.put("descripcion", "descripcion mayor de 45 caracteres");
        }
        Producto producto = new Producto(null, nombre, descripcion, precio);

        if (errores.isEmpty()) {
            productosService.guardar(producto);
            resp.sendRedirect(req.getContextPath() + "/producto");
        } else {
            req.setAttribute("errores", errores);
            req.setAttribute("producto", producto);
            getServletContext().getRequestDispatcher("/formulario.jsp").forward(req, resp);
        }

    }
}
