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
import java.util.List;

@WebServlet({"/productos","/productos-xls","/productos.html"})
public class ProductosXslServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ProductosService productosService = new ProductoServiceImp();
        List<Producto> proctos = productosService.listaProductos();

        String servletPath = req.getServletPath();
        boolean esXLS = servletPath.endsWith("xls");


        if (esXLS){
            resp.setContentType("application/vnd.ms-excel");
            resp.setHeader("Content-Disposition","attachment;filename=hojaProductos.xls");
        }

        try (PrintWriter salida = resp.getWriter()) {//try parametrizado

            if (!esXLS) {
                salida.println("<!DOCTYPE html>");
                salida.println("<html lang=\"en\">");
                salida.println("<head>");
                salida.println("<meta charset=\"UTF-8\">");
                salida.println("<title>Listado productos</title>");
                salida.println("</head>");
                salida.println("<body>");
                salida.println("<h1>Lista de productos de nuestra tienda</h1>");
                salida.println("<p><a href=\""+req.getContextPath()+"/productos-xls\" >Exporta Exel</a></p>");
            }
            salida.println("<table>");
            salida.println("<tr>");
            salida.println("<th> id </th>");
            salida.println("<th> Nombre </th>");
            salida.println("<th> Descripcion </th>");
            salida.println("<th> Precio </th>");
            salida.println("</tr>");
            proctos.forEach(producto -> {
                salida.println("<tr>");
                salida.println("<td>" + producto.getId() + "</td>");
                salida.println("<td>" + producto.getNombre() + "</td>");
                salida.println("<td>" + producto.getDescripcion() + "</td>");
                salida.println("<td>" + producto.getPrecio() + "</td>");
                salida.println("</tr>");
            });

            salida.println("</table>");

            if (!esXLS) {
                salida.println("</body>");
                salida.println("</html>");
            }
        }
    }
}
