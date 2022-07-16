package cic.diplojava.webcompras.filtros;

import cic.diplojava.webcompras.servisio.LoginService;
import cic.diplojava.webcompras.servisio.LoginServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/contenido-carro","/agregar-producto"})
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService loginService = new LoginServiceImp();
        Optional<String> username = loginService.getNombreUsuario((HttpServletRequest) servletRequest);
        if (username.isPresent()) {
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Pagina no autorizada!!!");
        }
    }
}
