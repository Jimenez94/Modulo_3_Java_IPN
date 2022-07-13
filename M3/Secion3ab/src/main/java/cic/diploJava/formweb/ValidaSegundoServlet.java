package cic.diploJava.formweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/validaSegundoServlet")
public class ValidaSegundoServlet extends HttpServlet {
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

        Map<String, String> errores = new HashMap<>();//permite almacenar objetos con una llave de tipo String y un valor de tipo String

        if (username == null || username.isBlank()) {
            errores.put("username","Usuario es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.put("password","Contraseña es requerida");
        }
        if (email == null || !email.contains("@")) {
            errores.put("","Email requerido o mal formado");
        }
        if (pais == null || email.isBlank()) {
            errores.put("email","Pais es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguajes","Seleccione un lenguaje");
        }
        if (roles == null || roles.length == 0) {
            errores.put("roles","Defina su rol o roles");
        }
        if (idioma == null) {
            errores.put("idioma","Seleccione un idioma");
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
                salida.println("<li>Oculto: " + oculto + "</li>");
                salida.println("</ul>");
                salida.println("</body>");
                salida.println("</html>");
            }
        } else {
            //se manda la lista de errores por medio se el Request y este se manda abajo
            req.setAttribute("errores", errores);
            //regresa el control al formulario
            //Se optiene el contexto de la aplicacion y todo se va a a mandar a un contexto de se llama /from.jsp, se tiene que mandar la informacion del formulario
            getServletContext().getRequestDispatcher("/formMejor.jsp").forward(req, resp);
        }
    }
}
