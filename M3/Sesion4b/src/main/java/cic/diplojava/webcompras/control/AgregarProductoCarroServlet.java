package cic.diplojava.webcompras.control;

import cic.diplojava.webcompras.modelo.ArticuloCarro;
import cic.diplojava.webcompras.modelo.CarroCompras;
import cic.diplojava.webcompras.modelo.Producto;
import cic.diplojava.webcompras.servisio.ProductoServiceImp;
import cic.diplojava.webcompras.servisio.ProductosService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-producto")
public class AgregarProductoCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        ProductosService productosService = new ProductoServiceImp();

        Optional<Producto> producto = productosService.buscaProducto(id);

        if (producto.isPresent()) {

            ArticuloCarro articuloCarro = new ArticuloCarro(1, producto.get());

            CarroCompras carroCliente = null;
            HttpSession session = req.getSession();
            if (session.getAttribute("carroCliente") == null) {
                carroCliente = new CarroCompras();
                session.setAttribute("carroCliente", carroCliente);
            } else {
                carroCliente = (CarroCompras) session.getAttribute("carroCliente");
            }
            carroCliente.agregarArticulos(articuloCarro);
        }
        resp.sendRedirect(req.getContextPath() + "/contenido-carro");
    }


}
