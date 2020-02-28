package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.CustomerOrderEntity;
import com.banana.entity.OrderedProductEntity;
import com.banana.entity.ProductDetailEntity;
import com.banana.entity.ProductEntity;

import java.sql.*;
import java.util.Calendar;

public class OrderedProductDAO {
    private MyConnectDB connectDB = new MyConnectDB();
//    private Double totalEarning;

    public int insertOrderProduct(ProductEntity product, CustomerOrderEntity order, int quantity){
        String query = "INSERT INTO emarkett.ordered_product (order_id, product_id, quantity) VALUES " +
                "(?,?,?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setInt(1, order.getOrderId());
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.setInt(3, quantity);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int insertOrderProduct(OrderedProductEntity orderedProductEntity){
        String query = "INSERT INTO emarkett.ordered_product (order_id, product_id, quantity) VALUES " +
                "(?,?,?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setInt(1, orderedProductEntity.getOrderId());
            preparedStatement.setInt(2, orderedProductEntity.getProductId());
            preparedStatement.setInt(3, 1);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
        public int insertOrderProduct(int orderId, int productId){
        String query = "INSERT INTO emarkett.ordered_product (order_id, product_id, quantity) VALUES " +
                "(?,?,?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, 1);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public Double getTotalEarning (){
        String query = "SELECT sum(emarkett.product.price * emarkett.ordered_product.quantity * emarkett.customer_order" +
                ".amount) as " +
                "total FROM " +
                "emarkett.ordered_product, emarkett.product, emarkett.customer_order\n" +
                "where  ordered_product.product_id = product.product_id and ordered_product.order_id = customer_order" +
                ".order_id";
        Double rs = null;
        try {
            Statement statement = connectDB.getMyConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next();
            rs = resultSet.getDouble("total");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        OrderedProductDAO orderedProductDAO= new OrderedProductDAO();
        System.out.println(orderedProductDAO.getTotalEarning());
    }
}
