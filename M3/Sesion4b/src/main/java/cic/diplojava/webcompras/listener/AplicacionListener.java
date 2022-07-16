package cic.diplojava.webcompras.listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class AplicacionListener implements ServletContextListener,
        ServletRequestListener, HttpSessionListener {

    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.log("Iniciando una aplicacion Web Compras");
        context.setAttribute("mensaje", "Mensaje para toda la APP-WebCompras");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.log("Destruyendo la aplicacion WebCompras");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        context.log("Inicializando un request");
        sre.getServletContext().setAttribute("mensaje", "Mensaje para el request");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        context.log("Destruyendo request");

    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        context.log("Creando una sesion HTTP");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        context.log("Destruyendo una sesion HTTP");
        context.log("Destruyendo una sesion HTTP");
    }
}
