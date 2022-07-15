package cic.diplojava.webheaders.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/hora.actual")
public class HoraActualServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setHeader("refresh","2");//hace una llamada ael servidor

        LocalTime hora = LocalTime.now();//se obtiene la hora actual
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");//Para imprimirla en un formato

        try (PrintWriter salida = resp.getWriter()) {//try parametrizado
            salida.println("<!DOCTYPE html>");
            salida.println("<html lang=\"en\">");
            salida.println("<head>");
            salida.println("<meta charset=\"UTF-8\">");
            salida.println("<title>Hora actual</title>");
            salida.println("</head>");
            salida.println("<body>");
            salida.println("<h1>Hora actual del servidor</h1>");
            salida.println("<h3>" + hora.format(dtf) + "</h3>");
            salida.println("</body>");
            salida.println("</html>");
        }
    }
}
