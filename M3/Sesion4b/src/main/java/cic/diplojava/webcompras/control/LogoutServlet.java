package cic.diplojava.webcompras.control;

import cic.diplojava.webcompras.servisio.LoginService;
import cic.diplojava.webcompras.servisio.LoginServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService autoriza = new LoginServiceImp();
        Optional<String> username = autoriza.getNombreUsuario(req);

        if (username.isPresent()) {
            HttpSession sessionActual = req.getSession();
            sessionActual.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}
