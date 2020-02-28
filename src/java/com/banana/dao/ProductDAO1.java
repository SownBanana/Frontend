///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.banana.dao;
//
//import com.banana.entity.ProductDetailEntity;
//import com.banana.entity.ProductEntity;
//import com.banana.common.MyConnectDB;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
///**
// *
// * @author SownBanana
// */
//public class ProductDAO {
//    private int noOfRecords;
//    private MyConnectDB connectDB = new MyConnectDB();
//
//    public List<ProductEntity> viewAllProduct(int offset, int noOfRecords){
//        
//            String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product LIMIT " + offset + ", "+ noOfRecords;
//            List<ProductEntity> list = new ArrayList<ProductEntity>();
//            ProductEntity product = null;
//         try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//             while (rs.next()) {                 
//                 product = new ProductEntity();
//                 product.setProductId(rs.getInt("product_id"));
//                 product.setName(rs.getString("name"));
//                 product.setPrice(rs.getDouble("price"));
//                 product.setDescription(rs.getString("description"));
//                 product.setDescriptionDetail(rs.getString("description_detail"));
//                 product.setImage(rs.getString("image"));
//                 product.setThumbImage(rs.getString("thumb_image"));
//                 product.setLastUpdate(rs.getDate("last_update"));
//                 product.setCategoryId(rs.getInt("category_category_id"));
//                 product.setBrand(rs.getString("brand"));
//                 list.add(product);
//             }
//             rs.close();
//             rs = statement.executeQuery("SELECT FOUND_ROWS();");
//             if(rs.next()){
//                 this.noOfRecords = rs.getInt(1);
//             }
//        } catch (SQLException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//        return list;
//    }
//    public List<ProductEntity> getAllProduct(){
//        
//            String query = "SELECT  * FROM emarkett.product";
//            List<ProductEntity> list = new ArrayList<ProductEntity>();
//            ProductEntity product = null;
//         try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//             while (rs.next()) {                 
//                 product = new ProductEntity();
//                 product.setProductId(rs.getInt("product_id"));
//                 product.setName(rs.getString("name"));
//                 product.setPrice(rs.getDouble("price"));
//                 product.setDescription(rs.getString("description"));
//                 product.setDescriptionDetail(rs.getString("description_detail"));
//                 product.setImage(rs.getString("image"));
//                 product.setThumbImage(rs.getString("thumb_image"));
//                 product.setLastUpdate(rs.getDate("last_update"));
//                 product.setCategoryId(rs.getInt("category_category_id"));
//                 product.setBrand(rs.getString("brand"));
//                 list.add(product);
//             }
//             rs.close();
//             
//        } catch (SQLException e) {
//             e.printStackTrace();
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//        return list;
//    }
//    
//    public List<ProductEntity> viewAllProductByCategory(int offset, int noOfRecords, int category){
//        //1-laptop 2-cellphone ...
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE category_category_id = " + category
//                + " ORDER BY last_update DESC  LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> searchProduct(int offset, int noOfRecords, String names){
//        String[] input = names.split(" ");
//        String sql = "";
//        for (int i = 0; i < input.length - 1; i++) {
//            sql = sql + "name like N'%" + input[i] + "%' or description like N'%" + input[i] + "%' or ";
//        }
//        sql = sql + "name like N'%" + input[input.length - 1] + "%' or description like N'%" + input[input.length - 1] + "%'";
//        //1-laptop 2-cellphone ...
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE " + sql +  " LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    public List<ProductEntity> viewAllProductByName(int offset, int noOfRecords, String names){
//        //1-laptop 2-cellphone ...
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE name LIKE N'%" + names + "%' LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//
//    public List<ProductEntity> viewAllProductByPrice(int offset, int noOfRecords, Double minPrice, Double maxPrice,
//                                                      String order){        // ASC - Tăng dần, DESC -- giảm dần
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE price >= " + minPrice + " and price <= "+ maxPrice+ " order by price " + order + " LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    //Khoảng giá theo loại sp
//    public List<ProductEntity> viewAllProductByPrice(int offset, int noOfRecords, Double minPrice, Double maxPrice,
//                                                     String order, Integer categoryId){// ASC - Tăng dần, DESC- giảm dần
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE price >= " + minPrice + " and price <= "+ maxPrice+" and category_category_id = " + categoryId +
//                " order by " +
//                "price " + order + " LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> viewAllProductByDateModified(int offset, int noOfRecords){        // mới nhất trước
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product ORDER BY last_update DESC LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> viewAllProductByDateModified(int offset, int noOfRecords, Integer categoryId){        //
//        // mới nhất trước
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE category_category_id = " + categoryId + " ORDER BY last_update DESC LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> viewAllProductByBrand(int offset, int noOfRecords, String brand){        //
//        // mới nhất trước
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE brand = '" + brand + "' LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> viewAllProductByBrand(int offset, int noOfRecords, String brand, Integer categoryId){        //
//        // mới nhất trước
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product WHERE brand = " + brand + " AND category_category_id = " + categoryId + " LIMIT " + offset + ", "+ noOfRecords;
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    //được mua nhiều nhất
//    public List<ProductEntity> viewBestSellProduct(int offset, int noOfRecords){
//        String query = "SELECT quantity, p.* FROM emarkett.product as p, (\n" +
//                "\tselect product_id, sum(quantity) as quantity from ordered_product\n" +
//                "    group by product_id\n" +
//                ") as bestSell\n" +
//                "where p.product_id = bestSell.product_id\n" +
//                "order by bestSell.quantity desc";
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<ProductEntity> viewBestSellProduct(int offset, int noOfRecords, Integer categoryId){        // mới nhất
//        // trước
//        String query = "SELECT quantity, p.* FROM emarkett.product as p, (\n" +
//                "\tselect product_id, sum(quantity) as quantity from ordered_product\n" +
//                "    group by product_id\n" +
//                ") as bestSell\n" +
//                "where p.product_id = bestSell.product_id and p.category_category_id = " + categoryId+ "\n" +
//                "order by bestSell.quantity desc";
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public ProductEntity getProduct(Integer productId){
//
//        String query = "SELECT * FROM emarkett.product WHERE product_id = " + productId;
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            rs.next();
////            System.out.println(rs.getNString("name"));
//            product = new ProductEntity();
//            product.setProductId(rs.getInt("product_id"));
//            product.setName(rs.getString("name"));
//            product.setPrice(rs.getDouble("price"));
//            product.setDescription(rs.getString("description"));
//            product.setDescriptionDetail(rs.getString("description_detail"));
//            product.setImage(rs.getString("image"));
//            product.setThumbImage(rs.getString("thumb_image"));
//            product.setLastUpdate(rs.getDate("last_update"));
//            product.setCategoryId(rs.getInt("category_category_id"));
//            product.setBrand(rs.getString("brand"));
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
//
//
//    public ProductEntity getProduct(String name, String image){
//
//        String query = "SELECT * FROM emarkett.product WHERE name = '" + name + "' AND image = '" + image+"'";
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            rs.next();
//            product = new ProductEntity();
//            product.setProductId(rs.getInt("product_id"));
//            product.setName(rs.getString("name"));
//            product.setPrice(rs.getDouble("price"));
//            product.setDescription(rs.getString("description"));
//            product.setDescriptionDetail(rs.getString("description_detail"));
//            product.setImage(rs.getString("image"));
//            product.setThumbImage(rs.getString("thumb_image"));
//            product.setLastUpdate(rs.getDate("last_update"));
//            product.setCategoryId(rs.getInt("category_category_id"));
//            product.setBrand(rs.getString("brand"));
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return product;
//    }
//
//    //bộ lọc
//    public List<ProductEntity> fillterProducts(int offset, int noOfRecords, Double minPrice, Double maxPrice,
//                                                     String orderPrice, Integer categoryId, String brand){// ASC - Tăng
//        // dần, DESC- giảm dần
//        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM emarkett.product LIMIT " + offset + ", "+ noOfRecords +
//                "WHERE price >= " + minPrice + " and price <= "+ maxPrice;
//
//        if(categoryId == 0){
//            query = query + " AND category_category_id = " + categoryId;
//        }
//        if(!"".equals(brand)){
//            query = query + " AND brand = '" + brand +"'";
//        }
//        if(!"".equals(orderPrice)){
//            query = query + " order by price " + orderPrice;
//        }
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductEntity product = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                product = new ProductEntity();
//                product.setProductId(rs.getInt("product_id"));
//                product.setName(rs.getString("name"));
//                product.setPrice(rs.getDouble("price"));
//                product.setDescription(rs.getString("description"));
//                product.setDescriptionDetail(rs.getString("description_detail"));
//                product.setImage(rs.getString("image"));
//                product.setThumbImage(rs.getString("thumb_image"));
//                product.setLastUpdate(rs.getDate("last_update"));
//                product.setCategoryId(rs.getInt("category_category_id"));
//                product.setBrand(rs.getString("brand"));
//                list.add(product);
//            }
//            rs.close();
//            rs = statement.executeQuery("SELECT FOUND_ROWS();");
//            if(rs.next()){
//                this.noOfRecords = rs.getInt(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//    
//
//    public int insertProduct(ProductEntity product){
//        String query = "INSERT INTO `emarkett`.`product` (`name`, `price`, `description`, `description_detail`, " +
//                "`image`, `thumb_image`, `last_update`, `category_category_id`, `brand`) VALUES " +
//                "(?,?,?,?,?,?,?,?,?);";
//        PreparedStatement preparedStatement;
//        try{
//            Date now = new Date(Calendar.getInstance().getTime().getTime());
//            product.setLastUpdate(now);
//            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setDouble(2, product.getPrice());
//            preparedStatement.setString(3, product.getDescription());
//            preparedStatement.setString(4, product.getDescriptionDetail());
//            preparedStatement.setString(5, product.getImage());
//            preparedStatement.setString(6, product.getThumbImage());
//            preparedStatement.setDate(7, product.getLastUpdate());
//            preparedStatement.setInt(8, product.getCategoryId());
//            preparedStatement.setString(9, product.getBrand());
//            return preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//    public int insertProduct(String name, Double price, String desc, String desc_detail, String image,
//                             String thumbImage, Integer categoryId, String brand){
//        String query = "INSERT INTO `emarkett`.`product` (`name`, `price`, `description`, `description_detail`, " +
//                "`image`, `thumb_image`, `last_update`, `category_category_id`, `brand`) VALUES " +
//                "(?,?,?,?,?,?,?,?,?);";
//        PreparedStatement preparedStatement;
//        try{
//            Date now = new Date(Calendar.getInstance().getTime().getTime());
//            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
//            preparedStatement.setString(1, name);
//            preparedStatement.setDouble(2, price);
//            preparedStatement.setString(3, desc);
//            preparedStatement.setString(4, desc_detail);
//            preparedStatement.setString(5, image);
//            preparedStatement.setString(6, thumbImage);
//            preparedStatement.setDate(7, now);
//            preparedStatement.setInt(8, categoryId);
//            preparedStatement.setString(9, brand);
//            return preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//    public int updateProduct(ProductEntity product){
//        String query = "UPDATE `emarkett`.`product` SET `name` = ?, `price` = ?," +
//                " `description` = ?, `description_detail` = ?, `image` = ?, `thumb_image` =" +
//                " ?, `last_update` = ?, `category_category_id` = ? , `brand = ?` WHERE " +
//                "(`product_id` = ?);";
//        PreparedStatement preparedStatement;
//        try{
//            Date now = new Date(Calendar.getInstance().getTime().getTime());
//            product.setLastUpdate(now);
//            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
//            preparedStatement.setString(1, product.getName());
//            preparedStatement.setDouble(2, product.getPrice());
//            preparedStatement.setString(3, product.getDescription());
//            preparedStatement.setString(4, product.getDescriptionDetail());
//            preparedStatement.setString(5, product.getImage());
//            preparedStatement.setString(6, product.getThumbImage());
//            preparedStatement.setDate(7, product.getLastUpdate());
//            preparedStatement.setInt(8, product.getCategoryId());
//            preparedStatement.setString(9, product.getBrand());
//            preparedStatement.setInt(10, product.getProductId());
//
//            return preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    public boolean deleteProduct(int id){
//        String query = "DELETE FROM `emarkett`.`product` WHERE product_id = " + id +
//                "DELETE FROM `emarkett`.`product_detail` WHERE product_id = " + id +
//                "DELETE FROM `emarkett`.`customer_order` WHERE ordered_product_product_id = " + id +
//                "DELETE FROM `emarkett`.`order_product` WHERE product_id = " + id ;
//        try{
//        Statement statement = connectDB.getMyConnection().createStatement();
//        return statement.execute(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//    public int getNoOfRecords() {
//        return noOfRecords;
//    }
//
//    public static void main(String[] args) {
//        ProductDAO dao = new ProductDAO();
//        ProductEntity product = dao.getProduct(2);
//        List<ProductEntity> list = dao.viewAllProductByCategory(0, 5, 1);
//        for (ProductEntity productEntity : list) {
//            System.out.println(productEntity.getName());
//        }
//        System.out.println(dao.noOfRecords);
//       
//    }
//}
