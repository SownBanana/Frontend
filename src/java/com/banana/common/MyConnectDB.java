/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banana.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class MyConnectDB {

    public static Statement statement = null;//run 1 cau querry// cosloi bao mat 
    public static PreparedStatement preStatement = null; // khac phuc loi bao mat
    public static Connection connection = null;
    public static ResultSet resultset = null;// don nhan ket qua tra ve

    protected static void driverTest() throws ClassNotFoundException {
        try {
            Class.forName(Config.DRIVER);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("SQL Server JDBC Driver not found");
        }

    }

    public Connection getMyConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            driverTest();
            connection = DriverManager.getConnection(Config.URL, Config.USER, Config.PASS);
        }
        return connection;
    }

    public Statement getMyStatement() throws SQLException, ClassNotFoundException {
        if (statement == null ? true : statement.isClosed()) {
            statement = getMyConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE/*doc tung dong*/,
                    ResultSet.CONCUR_READ_ONLY/*co che chi doc*/);
        }
        return statement;
    }

    // ham truyen cau query vao
    public ResultSet excuteStatementQuery(String Query) throws SQLException, ClassNotFoundException {
        try {
            resultset = getMyStatement().executeQuery(Query);
            return resultset;
        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage() + ": " + Query);
        } finally{
            try {
                closeConnecttion();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                throw new SQLException("Close error: " + ex.toString() + " !!");
            }
        }
    }
   
    public PreparedStatement getPreparedStatment(String sql) throws SQLException, ClassNotFoundException{
        if(preStatement==null ? true : preStatement.isClosed()){ 
            try {
                 preStatement= getMyConnection().prepareStatement(sql);
                
            } catch (Exception e) {
                    System.out.println("co loi"+e.getMessage());
            }
        }
        return preStatement;
    }
     // dodoi thanh eupdet , kieu du lieu tra ve int
    public Integer excuteStatementUpdate(String Query) throws SQLException, ClassNotFoundException {
        int current = 0;
        try {
             current = getMyStatement().executeUpdate(Query);
            return current;
        } catch (SQLException e) {
            throw new SQLException("Error: " + e.getMessage() + ": " + Query);
        } finally{
            closeConnecttion();
        }

    }

    public void closeConnecttion() throws SQLException {

        try {
            if (resultset != null && resultset.isClosed()) {
                resultset.close();
                resultset = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Resultset!");
        }

        try {
            if (statement != null && statement.isClosed()) {
                statement.close();
                statement = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Statement!");
        }

        try {
            if (connection != null && connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            throw new SQLException("Error close Connection!");
        }
    }
    
}
