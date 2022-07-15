package cic.diplojava.webcompras.servisio;


import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    Optional<String> getNombreUsuario(HttpServletRequest request);
}
