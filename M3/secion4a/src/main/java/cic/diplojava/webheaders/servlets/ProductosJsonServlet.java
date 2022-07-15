package cic.diplojava.webheaders.servlets;

import cic.diplojava.webheaders.modelo.Producto;
import cic.diplojava.webheaders.servicio.ProductoServiceImp;
import cic.diplojava.webheaders.servicio.ProductosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/productos-json")
public class ProductosJsonServlet extends HttpServlet {
    //se hace una peticion
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pide el reques y regresa un json
        ProductosService productosService = new ProductoServiceImp();
        List<Producto> productos = productosService.listaProductos();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        resp.setContentType("application/json");
        resp.getWriter().write(json);
    }

    //Este metodo esta pensado para hacer una peticion al servidor y que esta me devuelva un dato
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Vamos a esperar a que nos envien un json
        //y yo presentar una página como si fuera HTML
        ServletInputStream jsonStream = req.getInputStream();//necesito la entrada el cual es el un json
        ObjectMapper on = new ObjectMapper();//lo mapero en json a un objeto de tipo producto
        Producto producto = on.readValue(jsonStream,Producto.class);//quiero tranformar un json a un objeto tipo Producto

        resp.setContentType("text/html");

                try (PrintWriter salida = resp.getWriter()) {//try parametrizado
                    salida.println("<!DOCTYPE html>");
                    salida.println("<html lang=\"en\">");
                    salida.println("<head>");
                    salida.println("<meta charset=\"UTF-8\">");
                    salida.println("<title>Detalle Producto</title>");
                    salida.println("</head>");
                    salida.println("<body>");
                    salida.println("<h1>Detalle Producto Json</h1>");
                    salida.println("<ul>");
                    salida.println("<li>" + producto.getId() + "</li>");
                    salida.println("<li>" + producto.getNombre() + "</li>");
                    salida.println("<li>" + producto.getDescripcion() + "</li>");
                    salida.println("<li>" + producto.getPrecio() + "</li>");
                    salida.println("</ul>");
                    salida.println("</body>");
                    salida.println("</html>");
                }

    }
}
