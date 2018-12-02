/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Diaz
 */
public class ConexionSingleton {
    private static ConexionSingleton instance;
    private Connection _connection;

    private ConexionSingleton() {
        try {
            DriverManager.registerDriver(new Driver());
            _connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/demopatrones?useSSL=false", "root", "admin");
        } catch (SQLException e) {
            System.out.println("Error al registrar el controlador" + e.getMessage());
        }
    }

    public static ConexionSingleton getInstance() {
        if (instance == null) {
            instance = new ConexionSingleton();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return _connection;
    }
}
