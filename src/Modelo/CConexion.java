package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CConexion {
    Connection con;
    public static final String URL = "jdbc:mysql://localhost:3306/bdrestaurante";
    public static final String USER = "root";
    public static final String CLAVE = "Cheems2.0";
    
    public Connection conectar() {
        try {
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("Conectado");
        } catch (SQLException e) {
            System.out.println("Error :" + e);
        }
        return con;
    }
}
