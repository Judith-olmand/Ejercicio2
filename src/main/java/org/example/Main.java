package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                DBConfig.getUrl(),
                DBConfig.getUser(),
                DBConfig.getPassword()); Statement statement = conn.createStatement()){
            System.out.println("Conexión establecida con Oracle.");
            String sql = "CREATE TABLE empleado (" +
                    "id NUMBER PRIMARY KEY, " +
                    "nombre VARCHAR2(100), " +
                    "salario NUMBER(10,2))";
            statement.executeUpdate(sql);
            System.out.println("Tabla 'empleado' creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}