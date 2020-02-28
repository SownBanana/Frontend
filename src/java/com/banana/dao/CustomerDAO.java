package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.CustomerEntity;
import com.banana.entity.CustomerLvEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDAO {

    MyConnectDB myConnectDB = new MyConnectDB();

    public List<CustomerEntity> getAllCustomer() {
        ArrayList<CustomerEntity> listCustomer = new ArrayList<CustomerEntity>();
        try {

            String sql = "select * from emarkett.customer";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CustomerEntity customer = new CustomerEntity();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCityRegion(rs.getString("city_region"));
                customer.setPhone(rs.getInt("phone"));
                customer.setPassword(rs.getString("password"));
                customer.setLevel(rs.getInt("level"));
                listCustomer.add(customer);

            }

        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listCustomer;
    }

    public CustomerEntity getEmailCustomer(String email, String pass) {

        try {
            CustomerEntity customer = new CustomerEntity();
            String sql = "select * from emarkett.customer where customer.email=? and customer.password=?";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCityRegion(rs.getString("city_region"));
                customer.setPhone(rs.getInt("phone"));
                customer.setEmail(rs.getString("password"));
                customer.setLevel(rs.getInt("level"));
            }
            return customer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public CustomerEntity getEmail(String email) {

        try {
            CustomerEntity customer = new CustomerEntity();
            String sql = "select * from emarkett.customer where customer.email=? ";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCityRegion(rs.getString("city_region"));
                customer.setPhone(rs.getInt("phone"));
                customer.setEmail(rs.getString("password"));
                customer.setLevel(rs.getInt("level"));
            }
            return customer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public CustomerEntity getIdCustomer(int id) {

        try {
            CustomerEntity customer = new CustomerEntity();
            String sql = "select * from emarkett.customer where customer.customer_id=?";
            PreparedStatement preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAddress(rs.getString("address"));
                customer.setEmail(rs.getString("email"));
                customer.setCityRegion(rs.getString("city_region"));
                customer.setPhone(rs.getInt("phone"));
                customer.setPassword(rs.getString("password"));
                customer.setLevel(rs.getInt("level"));
            }
            return customer;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int addCutomer(CustomerEntity customer) {
        String sql = "INSERT into emarkett.customer(name,address,phone,city_region,email,password) value(?,?,?,?,?,?);";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(3, customer.getPhone());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(4, customer.getCityRegion());

            preparedStatement.setString(5, customer.getEmail());
            preparedStatement.setString(6, customer.getPassword());
            int rs = preparedStatement.executeUpdate();
            if (rs > 0) {
                System.out.println("thêm thành công !!");
            }
            return rs;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void updateUser(CustomerEntity customer) {
        String sql = "Update emarkett.customer set name=?,phone=?,address=?,city_region=?, password=? where customer.customer_id=?;";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getPhone());
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getCityRegion());

            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setInt(6, customer.getCustomerId());
            int rs = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatePass(int phone/*, String email*/, String pass) {
        String sql = "Update emarkett.customer set password=? where customer.phone=?;";
//        String sql = "Update emarkett.customer set password=? where customer.phone=? and customer.email='?';";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(1, pass);
            preparedStatement.setInt(2, phone);
//            preparedStatement.setString(3, email);

            int rs = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateLv(CustomerEntity customerEntity) {
        String sql = "Update emarkett.customer set level=? where customer.customer_id=?;";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = myConnectDB.getMyConnection().prepareStatement(sql);
            //preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(1, customerEntity.getLevel());
            preparedStatement.setInt(2, customerEntity.getCustomerId());

            int rs = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CustomerDAO c = new CustomerDAO();
//        List<CustomerEntity> cd =c.getAllCustomer();
//        for (CustomerEntity e:cd) {
//            System.out.println(e.getEmail());
//        }
//       CustomerEntity ee = c.getEmailCustomer("hsdh@gmjdk","eeee");
//        System.out.println(ee.getName());
        CustomerEntity e = c.getEmailCustomer("s.v.o.a.26@gmail.com", "99999999");
        System.out.println(e.getName());
//        e.setName("Pham Son");
//        e.setPassword("99999999");
//        e.setCityRegion("HD");
//        e.setAddress("DX-HD");
//        e.setPhone(986414971);
//        e.setEmail("s.v.o.a.26@gmail.com");
//        c.addCutomer(e);

    }

}
