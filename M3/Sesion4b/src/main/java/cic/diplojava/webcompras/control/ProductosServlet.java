package cic.diplojava.webcompras.control;

import cic.diplojava.webcompras.modelo.Producto;
import cic.diplojava.webcompras.servisio.LoginService;
import cic.diplojava.webcompras.servisio.LoginServiceImp;
import cic.diplojava.webcompras.servisio.ProductoServiceImp;
import cic.diplojava.webcompras.servisio.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})//contextos
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductosService service = new ProductoServiceImp();
        List<Producto> productos = service.listaProductos();

        LoginService autoriza = new LoginServiceImp();
        Optional<String> usernameOptional = autoriza.getNombreUsuario(req);


        resp.setContentType("text/html");

        try (PrintWriter salida = resp.getWriter()) {//try parametrizado
            salida.println("<!DOCTYPE html>");
            salida.println("<html lang=\"en\">");
            salida.println("<head>");
            salida.println("<meta charset=\"UTF-8\">");
            salida.println("<title>Lista de producto</title>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("<h1>Lista de productos</h1>");

            if (usernameOptional.isPresent()) {
                salida.println("<div style='color:blue;'>" + usernameOptional.get() + " Bienvenido! </div>");
            }

            salida.println("<table>");
            salida.println("<tr>");
            salida.println("<th> id </th>");
            salida.println("<th> Nombre </th>");
            salida.println("<th> Descripcion </th>");
            salida.println("<th> Precio </th>");
            salida.println("</tr>");
            productos.forEach(producto -> {
                salida.println("<tr>");
                salida.println("<td>" + producto.getId() + "</td>");
                salida.println("<td>" + producto.getNombre() + "</td>");
                salida.println("<td>" + producto.getDescripcion() + "</td>");

                if (usernameOptional.isPresent()) {
                    salida.println("<td>" + producto.getPrecio() + "</td>");
                }

                salida.println("</tr>");
            });
            salida.println("</table>");

            salida.println("</body>");
            salida.println("</html>");
        }
    }
}
