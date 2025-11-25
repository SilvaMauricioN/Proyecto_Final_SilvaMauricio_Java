package com.museo.api.museo_api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
public class DatabaseConnectionTest {
    
    @Autowired
    private DataSource dataSource;
    
    @Test
    public void testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("Conexión exitosa!");
            System.out.println("Database: " + connection.getCatalog());
        } catch (Exception e) {
            System.err.println("❌ Error al conectar: " + e);
            e.printStackTrace();
        }
    }
}