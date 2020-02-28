package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.CustomerEntity;
import com.banana.entity.CustomerOrderEntity;
import com.banana.entity.ProductEntity;
import com.banana.entity.ShowProduct;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerOrderDAO {

    MyConnectDB myConnectDB = new MyConnectDB();

    public List<CustomerOrderEntity> getAllOrderCustomer() {
        ArrayList<CustomerOrderEntity> listOrderCustomer = new ArrayList<CustomerOrderEntity>();
        try {

            String sql = "select * from emarkett.customer_order";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CustomerOrderEntity customerOrder = new CustomerOrderEntity();
                customerOrder.setOrderId(rs.getInt("order_id"));
                customerOrder.setAmount(rs.getInt("amount"));//so luong
                customerOrder.setDateCreated(rs.getDate("date_created"));
                customerOrder.setCustomer_id(rs.getInt("customer_customer_id"));
                listOrderCustomer.add(customerOrder);
            }
            return listOrderCustomer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public CustomerOrderEntity getOrderCustomer(int id) {

        try {
            CustomerOrderEntity customer = new CustomerOrderEntity();
            String sql = "select * from emarkett.customer_order where order_id=?";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                customer.setOrderId(rs.getInt("customer_id"));
                customer.setCustomer_id(rs.getInt("customer_customer_id"));
                customer.setAmount(rs.getInt("amount"));
                customer.setDateCreated(rs.getDate("date_created"));
            }
            return customer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int addOrderCutomer(CustomerEntity customer, CustomerOrderEntity customerOrder) {
        String sql = "INSERT into emarkett.customer_order(amount,date_created,customer_customer_id) value(?,?,?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            preparedStatement.setInt(1, 1);
            preparedStatement.setDate(2, now);
            preparedStatement.setInt(3, customer.getCustomerId());
            int rs = preparedStatement.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
     public List<ShowProduct> getAllOrder(int id) {

        try {
            List<ShowProduct> list = new ArrayList<ShowProduct>();
            String sql = "SELECT customer_order.order_id,product.name,date_created,product.product_id, product.image FROM emarkett.customer_order, emarkett.ordered_product, emarkett.product WHERE customer_order.order_id = ordered_product.order_id AND ordered_product.product_id = product.product_id AND customer_customer_id = ?";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                ShowProduct order = new ShowProduct();
                order.setOrder_id(rs.getInt("order_id"));
                order.setName(rs.getString("name"));
                order.setCreated((Date)rs.getDate("date_created"));
                order.setProductId(rs.getInt("product_id"));
                order.setImage(rs.getString("image"));
                list.add(order);
            }
            return list;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
     
        public int addOrderCutomer(int customerId) {
        String sql = "INSERT into emarkett.customer_order(amount,date_created,customer_customer_id) value(?,?,?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            preparedStatement.setInt(1, 1);
            preparedStatement.setDate(2, now);
            preparedStatement.setInt(3, customerId);
            int rs = preparedStatement.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public Integer getOrderId() {
        ResultSet rs;
        try {
            rs = myConnectDB.getMyConnection().createStatement().executeQuery("SELECT order_id FROM emarkett.customer_order order by order_id desc limit 1");
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int delOrderCustomer(int id) {
        String sql = "delete from emarkett.customer_order where emarkett.customer_order.order_id=?;";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    public static void main(String[] args) {
        CustomerOrderDAO d = new CustomerOrderDAO();
//        if(d.delOrderCustomer(2)>0){
//            System.out.println( "thanh cong");
//        }
        d.getOrderCustomer(1);
    }

}
