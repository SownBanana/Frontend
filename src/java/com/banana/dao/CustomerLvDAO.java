package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.CustomerEntity;
import com.banana.entity.CustomerLvEntity;
import com.banana.entity.CustomerOrderEntity;
import com.banana.entity.ProductEntity;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerLvDAO {
    MyConnectDB myConnectDB = new MyConnectDB();

    public List<CustomerLvEntity> getAllCustomerLv() {
        List<CustomerLvEntity> listLvCustomer = new ArrayList<CustomerLvEntity>();
        try {

            String sql = "select * from emarkett.customer_lv";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CustomerLvEntity lvCustomer = new CustomerLvEntity();
                lvCustomer.setCustomerId(rs.getInt("customer_id"));
                lvCustomer.setDiscount(rs.getInt("discount"));
                lvCustomer.setLevel(rs.getInt("level"));
                listLvCustomer.add(lvCustomer);
            }


        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listLvCustomer;
    }

    public CustomerLvEntity getIdLvCustomer(int id) {

        try {
            CustomerLvEntity lvCustomer = new CustomerLvEntity();
            String sql = "select * from emarkett.customer_lv where customer_id=?";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                lvCustomer.setCustomerId(rs.getInt("customer_id"));
                lvCustomer.setLevel(rs.getInt("level"));
                lvCustomer.setDiscount(rs.getInt("discount"));
            }
            return lvCustomer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addLvCutomer(CustomerEntity customer,CustomerLvEntity lvCustomer) {
        String sql = "INSERT into emarkett.customer_lv(customer_id, level, discount)  value(?,?,?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setInt(2,lvCustomer.getLevel());
            preparedStatement.setInt(3,lvCustomer.getDiscount());
            int rs = preparedStatement.executeUpdate();
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static void main(String[] args) {
        CustomerDAO c = new CustomerDAO();
        CustomerLvDAO l = new CustomerLvDAO();
        CustomerEntity ce = c.getEmailCustomer("hsdh@gmjdk","eeee");
        CustomerLvEntity cle = new CustomerLvEntity();
        cle.setLevel(2);
        cle.setDiscount(10);
        //cle.setCustomerId(ce.getCustomerId());
        if(l.addLvCutomer(ce,cle)>0) System.out.println("thanh cong roi");;
    }
}
