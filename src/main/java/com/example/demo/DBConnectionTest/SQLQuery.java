package com.example.demo.DBConnectionTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class SQLQuery {
    @Value("${spring.datasource.url}")
    public String dbUrl;

    @Autowired
    public DataSource dataSource;

    public String getFirstProductName() throws SQLException {
        String output = "failed";
        try (Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"Product\"");

            if (rs.next()) {
                output = rs.getString("name");
            }
        }
        return output;
    }
}
