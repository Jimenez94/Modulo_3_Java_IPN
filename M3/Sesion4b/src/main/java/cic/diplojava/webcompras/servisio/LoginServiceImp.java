package cic.diplojava.webcompras.servisio;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceImp implements LoginService {
    @Override
    public Optional<String> getNombreUsuario(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        String username = (String) httpSession.getAttribute("username");
        if (username != null) {
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
