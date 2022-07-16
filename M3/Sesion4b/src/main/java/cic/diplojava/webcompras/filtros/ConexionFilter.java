package cic.diplojava.webcompras.filtros;

import cic.diplojava.webcompras.util.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter("/*")
public class ConexionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try (Connection conexion = ConexionBD.getConexion()) {
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            try {
                servletRequest.setAttribute("conexion", conexion);
                filterChain.doFilter(servletRequest, servletResponse);
                conexion.commit();
            } catch (SQLException ex) {
                conexion.rollback();
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
