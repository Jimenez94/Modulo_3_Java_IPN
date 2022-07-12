package cic.diploJava.formweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/valida")
public class ValidaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");

        String[] lenguajes = req.getParameterValues("lenguajes");
        String[] roles = req.getParameterValues("roles");

        String idioma = req.getParameter("idioma");
        String soltero = req.getParameter("soltero");
        String oculto = req.getParameter("oculto");

        List<String> errores = new ArrayList<>();
        if (username == null || username.isBlank()) {
            errores.add("Usuario es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.add("Contraseña es requerida");
        }
        if (email == null || !email.contains("@")) {
            errores.add("Email requerido o mal formado");
        }
        if (pais == null || email.isBlank()) {
            errores.add("Pais es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.add("Seleccione un lenguaje");
        }
        if (roles == null || roles.length == 0) {
            errores.add("Defina su rol o roles");
        }
        if (idioma == null) {
            errores.add("Seleccione un idioma");
        }

        if (errores.isEmpty()) {
            try (PrintWriter salida = resp.getWriter()) {//try parametrizado
                salida.println("<!DOCTYPE html>");
                salida.println("<html lang=\"en\">");
                salida.println("<head>");
                salida.println("<meta charset=\"UTF-8\">");
                salida.println("<title>Resultado form</title>");
                salida.println("</head>");
                salida.println("<body>");
                salida.println("<h1>Resultado-formulario</h1>");
                salida.println("<ul>");
                salida.println("<li>Usuario: " + username + "</li>");
                salida.println("<li>Password: " + password + "</li>");
                salida.println("<li>Email: " + email + "</li>");
                salida.println("<li>Pais: " + pais + "</li>");
                salida.println("<li>Lenguajes<ul>");
                Arrays.asList(lenguajes).forEach(lenguaje -> {
                    salida.println("<li>" + lenguaje + "</li>");
                });
                salida.println("</ul></li>");
                salida.println("<li>Roles de usuario<ul>");
                Arrays.asList(roles).forEach(rol -> {
                    salida.println("<li>" + rol + "</li>");
                });
                salida.println("</ul></li>");
                salida.println("<li>Idioma: " + idioma + "</li>");
                salida.println("<li>Soltero: " + soltero + "</li>");
                salida.println("</ul>");
                salida.println("</body>");
                salida.println("</html>");
            }
        } else {
            req.setAttribute("errores",errores);
            //regresa el control al formulario
            getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
        }
    }
}


