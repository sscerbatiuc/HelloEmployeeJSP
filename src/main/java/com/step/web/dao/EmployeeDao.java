package com.step.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.sql.DriverManager;

public class EmployeeDao {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    // 172.15.145.32
    static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/emp_manager";
    // Database credentials
    static final String USER = "postgres";
    static final String PASS = "aozhnl";

    public EmployeeDao() {
        try {
            // Register JDBC driver
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Connection getConnection() throws SQLException {
        //Open a connection
        System.out.println("Connecting to a selected database...");
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
        return conn;
    }

    public void add(String name, String address, String phoneno) {
        String sql = "INSERT INTO app.employee(name, address, phoneno) VALUES (?,?,?)";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            Employee contact = new Employee(name, address, phoneno);

            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getAddress());
            pstmt.setString(3, contact.getPhoneno());
            System.out.println(contact);
            System.out.println("Executed query =" + sql);
            int rows = pstmt.executeUpdate();
            System.out.println("Inserted " + rows + " records into the table...");

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
    }

    public Map<Integer, Employee> getAll() {
        String query = "SELECT * FROM app.employee";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            Map<Integer, Employee> map = new HashMap<>();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee contact = new Employee(rs.getString(2), rs.getString(3), rs.getString(4));
                map.put(rs.getInt(1), contact);
            }
            System.out.println(map);
            return map;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return null;
    }

    public Map<Integer, Employee> getById(String id) {
        String query = "SELECT * FROM app.employee WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            Map<Integer, Employee> mapWithId = new HashMap<>();
            pstmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Employee contact = new Employee(rs.getString(2), rs.getString(3), rs.getString(4));
                mapWithId.put(Integer.parseInt(id), contact);
            }
            return mapWithId;

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return null;
    }

    // delete records based on id
    public void deleteEmployee(String id) {
        String query = "DELETE FROM app.employee WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, Integer.parseInt(id));
            // execute delete SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

    }

    // update records based on id
    public void update(String id, String name, String address, String phoneno) {
        String query = "UPDATE app.employee SET name = ?, address = ?, phoneno = ? " + " WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, phoneno);
            pstmt.setInt(4, Integer.parseInt(id));
            // execute update SQL stetement
            pstmt.executeUpdate();
            System.out.println("Record is Updated!");
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }

    }

}
