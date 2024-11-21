package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private static ConexionMySQL instancia;
    private Connection cn;

    private ConexionMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/tarea4", "root", "root");
            System.out.println("Conectado a la base de datos");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public static ConexionMySQL getInstancia() {
        if (instancia == null) {
            instancia = new ConexionMySQL();
        }
        return instancia;
    }

    public Connection getConexion() {
        return cn;
    }
}
