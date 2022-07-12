package cic.diploJava.holamundo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametro/get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        resp.setContentType("text/html");//variable en donde viaja la respuesta
        PrintWriter salida = resp.getWriter();//para describir el codigo que esta viejando en resp

        //getParameter --> recibe el nombre del parameter que enviaron
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");



        salida.println(" <!DOCTYPE html>");
        salida.println("<html >");
        salida.println("<head >");
        salida.println("    <meta charset = \"UTF-8\" >");
        salida.println("    <title>Parametros en ger-url</title>");
        salida.println("</head >");
        salida.println("<body >");
        salida.println("    <h1 > Parametros en ger-url</h1 >");

        if (saludo != null && nombre != null){//llegan los dos parameros
            salida.println("<h2>"+saludo+"</h2>");
            salida.println("<h2>El nombre es: "+nombre+"</h2>");
        }else if (saludo!= null ){//llego el saludo pero el nombre no
            salida.println("<h2>"+saludo+"</h2>");
            salida.println("<h2>El nombre es: Ciudadano anonimo </h2>");
        }else if(nombre != null){//llego el nombre pero el saludo no
            salida.println("<h2>Saludo sin parametros</h2>");
            salida.println("<h2>El nombre es: "+nombre+"</h2>");
        }else {//cuando no llega ningun parametro
            salida.println("<h2>No hay saludo</h2>");
            salida.println("<h2>No hay nombre</h2>");
        }

        try {
            int clave =(Integer.parseInt( req.getParameter("clave")));
            salida.println("<h2>La clave es: "+clave+"</h2>");
        }catch (NumberFormatException ex){
            salida.println("<h2>La clave no existe</h2>");
        }

        salida.println("</body >");
        salida.println("</html >");
        salida.close();

    }
}
