package cic.diplojava.webheaders.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/cabeceras-request")
public class CabecerasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String metodoRequest = req.getMethod();//obtencion del metodo
        String requestURI = req.getRequestURI();
        String requestURL = req.getRequestURL().toString();
        String contextPath = req.getContextPath();
        String servletPath = req.getServletPath();
        String ip = req.getLocalAddr();
        int port = req.getLocalPort();
        String ipCliente = req.getRemoteAddr();
        String servletName = req.getServerName();
        String schema = req.getScheme();
        try (PrintWriter salida = resp.getWriter()) {//try parametrizado
            salida.println("<!DOCTYPE html>");
            salida.println("<html lang=\"en\">");
            salida.println("    <head>");
            salida.println("        <meta charset=\"UTF-8\">");
            salida.println("        <title>Cabeceras Request</title>");
            salida.println("    </head>");
            salida.println("    <body>");
            salida.println("        <h1>Datos de Cabecera httpRequest</h1>");
            salida.println("        <h2>Informacion de la cabecera</h2>");
            salida.println("<ul>");
            salida.println("<li> Metodo Http: " + metodoRequest + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  URI: " + requestURI + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  URL: " + requestURL + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  Context Path: " + contextPath + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  Servlet Path: " + servletPath + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  IP Servidor " + ip + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  Puert " + port + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  ip cliente: " + ipCliente + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  server Name " + servletName + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<li>  Schema: " + schema + "</li>");//obtenemos el method con el que se obtiene el request
            salida.println("<br>");

            Enumeration<String> headerNames = req.getHeaderNames();
            while (headerNames.hasMoreElements()){
                String cabecera = headerNames.nextElement();
                salida.println("<li>" + cabecera+ " : "+req.getHeader(cabecera)+ "</li>");
            }

            salida.println("</ul>");
            salida.println("    </body>");
            salida.println("</html>");
        }
    }
}
