package cic.diplojava.webcompras.control;

import cic.diplojava.webcompras.servisio.LoginService;
import cic.diplojava.webcompras.servisio.LoginServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String Username = "admin";
    final static String PASSWORD = "admin";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LoginService login = new LoginServiceImp();
        Optional<String> usuarioActivo = login.getNombreUsuario(req);

        if (usuarioActivo.isPresent()) {

            resp.setContentType("text/html");

            try (PrintWriter salida = resp.getWriter()) {//try parametrizado
                salida.println("<!DOCTYPE html>");
                salida.println("<html lang=\"en\">");
                salida.println("<head>");
                salida.println("<meta charset=\"UTF-8\">");
                salida.println("<title>Bienvenido " + usuarioActivo.get() + "</title>");
                salida.println("</head>");
                salida.println("<body>");
                salida.println("<h2>Hola " + usuarioActivo.get() + " has iniciado serion correctamente!</h2>");
                salida.println("<p><a href = '" + req.getContextPath() + "/index.html'>Volver</a></p>");
                salida.println("<p><a href = '" + req.getContextPath() + "/logout'>Cerrar sesión</a></p>");
                salida.println("</body>");
                salida.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");//optencion de parametros
        String password = req.getParameter("password");

        if (Username.equals(username) && PASSWORD.equals(password)) {//validacion

            HttpSession session = req.getSession();//aguardamos el nombre del usuario en la sesion
            session.setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else {//si no es correcto
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no puedes pasar..");
        }
    }
}
