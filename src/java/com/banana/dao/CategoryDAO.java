package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.CategoryEntity;
import com.banana.entity.ProductEntity;
import javafx.scene.chart.CategoryAxis;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategoryDAO {
//    Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup("java:comp/env");
//            DataSource ds = (DataSource) envContext.lookup("jdbc/ProductDB");
//            Connection connection = ds.getConnection();

    public List<CategoryEntity> viewAllCatagoty(){

        String query = "SELECT * FROM emarkett.category";
        List<CategoryEntity> list = new ArrayList<CategoryEntity>();
        CategoryEntity category = null;
        try {
             Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/ProductDB");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                category = new CategoryEntity();
                category.setCategoryId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                category.setImage(rs.getString("image"));
                list.add(category);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public int insertCategory(CategoryEntity category){
//        String query = "INSERT INTO `emarkett`.`category` (`name`, `image`) VALUES ("+category.getName()+
//                ", "+ category.getImage()+")";
        String query =
                "INSERT INTO category(name, image) value (?, ?);";
        try{
             Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/ProductDB");
            Connection connection = ds.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getImage());
            return preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int updateCategory(CategoryEntity category){
        String query = "UPDATE `emarkett`.`product` SET `name` = ?, `image` = ? WHERE " +
                "(`category_id` = ?);";
        PreparedStatement preparedStatement;
        try{
             Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/ProductDB");
            Connection connection = ds.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getImage());
            preparedStatement.setInt(3, category.getCategoryId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean deleteCategory(int id){
        String query = "DELETE FROM `emarkett`.`category` WHERE category_id = " + id;
        try{
             Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/ProductDB");
            Connection connection = ds.getConnection();
            Statement statement = connection.createStatement();
            return statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        CategoryDAO dao = new CategoryDAO();
        CategoryEntity category = new CategoryEntity();
        category.setName("cellphone");
        category.setImage("phone img");
        System.out.println(category.getImage());
        System.out.println(dao.insertCategory(category));
//        System.out.println(dao.deleteCategory(3));

    }
}
