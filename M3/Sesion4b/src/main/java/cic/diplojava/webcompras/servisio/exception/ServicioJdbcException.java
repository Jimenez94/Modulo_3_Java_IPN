package cic.diplojava.webcompras.servisio.exception;

public class ServicioJdbcException extends RuntimeException{
    public ServicioJdbcException(String mensaje){
        super(mensaje);
    }
    public ServicioJdbcException(String mensaje, Throwable caussa){
        super(mensaje,caussa);
    }
}
