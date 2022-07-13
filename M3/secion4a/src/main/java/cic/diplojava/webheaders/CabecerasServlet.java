package cic.diplojava.webheaders;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("")
public class CabecerasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        try (PrintWriter salida = resp.getWriter()) {//try parametrizado
            salida.println("<!DOCTYPE html>");
            salida.println("<html lang=\"en\">");
            salida.println("    <head>");
            salida.println("        <meta charset=\"UTF-8\">");
            salida.println("        <title>Titulo</title>");
            salida.println("    </head>");
            salida.println("    <body>");
            salida.println("        <h1>Titulo</h1>");
            salida.println("    </body>");
            salida.println("</html>");
        }
    }
}
