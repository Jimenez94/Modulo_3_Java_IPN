package cic.diplojava.webheaders.servlets;

import cic.diplojava.webheaders.modelo.Producto;
import cic.diplojava.webheaders.servicio.ProductoServiceImp;
import cic.diplojava.webheaders.servicio.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/busca-producto")
public class BuscarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductosService productosService = new ProductoServiceImp();
        String nombre = req.getParameter("nombre");
        Optional<Producto> encontrado = productosService.listaProductos()
                .stream().filter(producto -> producto.getNombre().contains(nombre))
                .findFirst();

        if (encontrado.isPresent()) {
            resp.setContentType("text/html");

            try (PrintWriter salida = resp.getWriter()) {//try parametrizado
                salida.println("<!DOCTYPE html>");
                salida.println("<html lang=\"en\">");
                salida.println("<head>");
                salida.println("<meta charset=\"UTF-8\">");
                salida.println("<title>Producto Encontrado</title>");
                salida.println("</head>");
                salida.println("<body>");
                salida.println("<h1>Detalle del producto</h1>");
                salida.println("<h3> El nombre es: " + encontrado.get().getNombre() + "</h3>");
                salida.println("<h3> La descripcion es: " + encontrado.get().getDescripcion() + "</h3>");
                salida.println("<h3> El precio es: " + encontrado.get().getPrecio() + "</h3>");
                salida.println("</body>");
                salida.println("</html>");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Producto NO encontrado"+nombre);
        }
    }
}
