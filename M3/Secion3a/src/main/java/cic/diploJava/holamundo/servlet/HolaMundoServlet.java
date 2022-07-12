package cic.diploJava.holamundo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Peticion el contexto "Nombre del servicio"--> esta anotación funciona que nuestro servidor publique el contesto el cual es /hola-mundo
@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {
    @Override
    //Esto es lo que va a viajar en una petition
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //Petición Request
        //Respuesta Response

        resp.setContentType("text/html");//variable en donde viaja la respuesta
        PrintWriter salida = resp.getWriter();//para describir el codigo que esta viejando en resp
        salida.println(" <!DOCTYPE html>");
        salida.println("<html >");
        salida.println("<head >");
        salida.println("  <meta charset = \"UTF-8\" >");
        salida.println(" <title>Hola mundo Servlet</title>");
        salida.println("</head >");
        salida.println("<body >");
        salida.println(" <h1 > Hola mundo desde un Servlet</h1 >");
        for (int i = 1; i<20; i++){
            salida.println("<h3 style=\"color:red;\"> Haciendo un for</h3>");
        }
        salida.println("</body >");
        salida.println("</html >");
        salida.close();
    }
}
