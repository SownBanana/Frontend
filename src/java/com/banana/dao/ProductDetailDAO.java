package com.banana.dao;

import com.banana.common.MyConnectDB;
import com.banana.entity.ProductDetailEntity;
import com.banana.entity.ProductEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductDetailDAO {
    private MyConnectDB connectDB = new MyConnectDB();

//    public List<ProductEntity> viewAllProduct(){
//
//        String query = "SELECT * FROM emarkett.product_detail"
//        List<ProductEntity> list = new ArrayList<ProductEntity>();
//        ProductDetailEntity productDetail = null;
//        try {
//            Connection connection = connectDB.getMyConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(query);
//            while (rs.next()) {
//                productDetail = new ProductDetailEntity();
//                productDetail.setProductId(rs.getInt("product_id"));
//                productDetail.setInformation(rs.getString("name"));
//                productDetail.setPrice(rs.getDouble("price"));
//                productDetail.setDescription(rs.getString("description"));
//                productDetail.setDescriptionDetail(rs.getString("description_detail"));
//                productDetail.setImage(rs.getString("image"));
//                productDetail.setThumbImage(rs.getString("thumb_image"));
//                productDetail.setLastUpdate(rs.getDate("last_update"));
//                productDetail.setCategoryId(rs.getInt("category_category_id"));
//                productDetail.setProductDetailId(rs.getInt("product_detail_product_id"));
//                list.add(product);
//            }
//            rs.close();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

    public ProductDetailEntity getProductDetail(Integer productId){

        String query = "SELECT * FROM emarkett.product_detail WHERE product_id = " + productId;
        ProductDetailEntity productDetail = null;
        try {
            Connection connection = connectDB.getMyConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            productDetail = new ProductDetailEntity();
            productDetail.setProductId(rs.getInt("product_id"));
            productDetail.setInformation(rs.getString("information"));
            productDetail.setImage1(rs.getString("image1"));
            productDetail.setImage2(rs.getString("image2"));
            productDetail.setImage3(rs.getString("image3"));
            productDetail.setImage4(rs.getString("image4"));
            productDetail.setImage5(rs.getString("image5"));
            productDetail.setAccessories(rs.getString("accessories"));
            productDetail.setGuaranty(rs.getString("guaranty"));
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productDetail;
    }

    public int insertProductDetail(ProductDetailEntity productDetail){
        String query = "INSERT INTO emarkett.product_detail (product_id, information, image1, image2, image3, image4, image5, " +
                "accessories, guaranty) VALUES " +
                "(?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setInt(1, productDetail.getProductId());
            preparedStatement.setString(2, productDetail.getInformation());
            preparedStatement.setString(3, productDetail.getImage1());
            preparedStatement.setString(4, productDetail.getImage2());
            preparedStatement.setString(5, productDetail.getImage3());
            preparedStatement.setString(6, productDetail.getImage4());
            preparedStatement.setString(7, productDetail.getImage5());
            preparedStatement.setString(8, productDetail.getAccessories());
            preparedStatement.setString(9, productDetail.getGuaranty());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int insertProductDetail(Integer productId, String information, String image1, String image2, String image3,
                                   String image4,
                                   String image5, String accessories, String guaranty ){
        String query = "INSERT INTO emarkett.product_detail (product_id, information, image1, image2, image3, image4," +
                " image5, " +
                "accessories, guaranty) VALUES " +
                "(?,?,?,?,?,?,?,?,?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setInt(1, productId);
            preparedStatement.setString(2, information);
            preparedStatement.setString(3, image1);
            preparedStatement.setString(4, image2);
            preparedStatement.setString(5, image3);
            preparedStatement.setString(6, image4);
            preparedStatement.setString(7, image5);
            preparedStatement.setString(8, accessories);
            preparedStatement.setString(9, guaranty);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public int updateProductDetail(ProductDetailEntity productDetail){
        String query = "UPDATE emarkett.product_detail SET information = ?, image1 = ?, image2 = ?, image3 = ?, " +
                "image4 + ?, image5 = ?, accessories = ?, guaranty = ? " +
                "WHERE " +
                "(`product_id` = ?);";
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connectDB.getMyConnection().prepareStatement(query);
            preparedStatement.setString(1, productDetail.getInformation());
            preparedStatement.setString(2, productDetail.getImage1());
            preparedStatement.setString(3, productDetail.getImage2());
            preparedStatement.setString(4, productDetail.getImage3());
            preparedStatement.setString(5, productDetail.getImage4());
            preparedStatement.setString(6, productDetail.getImage5());
            preparedStatement.setString(7, productDetail.getAccessories());
            preparedStatement.setString(8, productDetail.getGuaranty());
            preparedStatement.setInt(9, productDetail.getProductId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static void main(String[] args) {
        ProductDetailDAO dao = new ProductDetailDAO();
        ProductDetailEntity pde = dao.getProductDetail(1);
        System.out.println(pde.getImage1());
    }
}
