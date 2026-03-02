package co.upgi.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/upgi";
    private static final String USER = "root";
    private static final String PASSWORD = "Caramelo3*"; // Cambia si tu MySQL tiene otra contraseña

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
