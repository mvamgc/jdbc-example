package io.twobeers.examples.jdbc;

import java.sql.*;
import java.util.Optional;

public class Connector {
    private Connection connection;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "123");
        System.out.println("Opened database successfully");
    }

    public void close() throws SQLException {
        connection.close();
    }
    public Optional<Integer> getDbData() throws SQLException {
        Optional<Integer> questionOfLife = Optional.empty();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("select 42");
        if(rs.next()) {
            questionOfLife = Optional.of(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        return questionOfLife;
    }
}
