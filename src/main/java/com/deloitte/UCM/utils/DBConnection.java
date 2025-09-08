package com.deloitte.UCM.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DBConnection {
    
    private final JdbcTemplate jdbcTemplate;
    
    private final DataSource dataSource;

    public DBConnection(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void checkConnection() {
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
             if (result != null && result == 1) {
                System.out.println("✅ Database connection established successfully!");
            } else {
                System.err.println("⚠️ Database connection failed or returned unexpected result!");
            }
             try(Connection connection = dataSource.getConnection()) {
        
            System.out.println("🔹 Connected to: " + connection.getMetaData().getURL());
            System.out.println("🔹 DB User: " + connection.getMetaData().getUserName());
            
            
        } catch (SQLException e) {
             System.err.println("❌ Failed to connect to the database!");
            e.printStackTrace();
        }
        } catch (Exception e) {
             System.err.println("❌ JdbcTemplate query failed!");
            e.printStackTrace();
        }
       
    }

      
}
