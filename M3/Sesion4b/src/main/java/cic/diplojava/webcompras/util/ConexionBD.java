package cic.diplojava.webcompras.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url = "jdbc:mysql://localhost:3060/diplojava?serverTimezone=America/Mexico_City";
    private static String username = "diplojava";
    private static String pass = "dipJava123$";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(url, username, pass);
    }

}
