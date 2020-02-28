//package com.banana.controller;
//
//import com.banana.dao.ProductDAO;
//import com.banana.dao.ProductDetailDAO;
//import com.banana.entity.ProductEntity;
//import java.io.File;
//import java.io.FileOutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.nio.file.Paths;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.http.Part;
//
//@WebServlet(urlPatterns = {"/admin/addProductF"})
//@MultipartConfig(maxFileSize = 16177215)
//public class AddProduct extends HttpServlet {
//
//    @Override
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        ProductDAO productDAO = new ProductDAO();
//        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
//
//        // MultipartFile file =(MultipartFile) request.getParameter("thumbImageProduct");
//        String name = request.getParameter("nameProduct");
//        Double price = Double.parseDouble(request.getParameter("priceProduct"));
//        String description = name;
//        String descriptionDetail = request.getParameter("description_detailProduct");
//        String image = "";// request.getParameter("imageProduct");
//        String thumbImage = "";//request.getParameter("thumbImageProduct");
//// ghi file
//
//        Part filePart = request.getPart("thumb"); // Retrieves <input type="file" name="file">
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
////        InputStream fileContent = filePart.getInputStream();
//        System.out.println(fileName);
//        String mess = "thanh cong";
//        Integer categoryID = 1; //Integer.parseInt(request.getParameter("categoryIdProduct"));
//        String brand = request.getParameter("brand");//request.getParameter("brandProduct");
//        productDAO.insertProduct(name, price, description, descriptionDetail, fileName, fileName,
//                categoryID, brand);
//        String information = request.getParameter("information");
//        String image1 = request.getParameter("image1");
//        String image2 = request.getParameter("image2");
//        String image3 = request.getParameter("image3");
//        String image4 = request.getParameter("image4");
//        String image5 = request.getParameter("image5");
//        String accessories = request.getParameter("accessories");
//        String guaranty = request.getParameter("guaranty");
////        ProductEntity product = productDAO.getProduct(name, image);
//        Integer productId = product.getProductId();
//        productDetailDAO.
//                insertProductDetail(productId, information, fileName, image2, image3, image4, image5,
//                        accessories, guaranty);
//        response.sendRedirect("form.jsp?mess=" + mess); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        ProductDAO productDAO = new ProductDAO();
//        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
//
//        // MultipartFile file =(MultipartFile) request.getParameter("thumbImageProduct");
//        String name = request.getParameter("nameProduct");
//        Double price = Double.parseDouble(request.getParameter("priceProduct"));
//        String description = name;
//        String descriptionDetail = request.getParameter("description_detailProduct");
//        String image = "";// request.getParameter("imageProduct");
//        String thumbImage = "";//request.getParameter("thumbImageProduct");
//// ghi file
//
//        Part filePart = request.getPart("thumb"); // Retrieves <input type="file" name="file">
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//        String path = "P:/emarket155/web/images/" + fileName;
//        try {
//            InputStream fileContent = filePart.getInputStream();
//            byte[] buffer = new byte[fileContent.available()];
//            fileContent.read(buffer);
//            File targetFile = new File(path);
//            OutputStream outStream = new FileOutputStream(targetFile);
//            outStream.write(buffer);
//        }catch(IOException exception){
//            exception.printStackTrace();
//        }
//        String mess = "thanh cong";
//        Integer categoryID = 1; //Integer.parseInt(request.getParameter("categoryIdProduct"));
//        String brand = request.getParameter("brand");//request.getParameter("brandProduct");
//        productDAO.insertProduct(name, price, description, descriptionDetail, path, path,
//                categoryID, brand);
//        String information = request.getParameter("information");
//        String image1 = request.getParameter("image1");
//        String image2 = request.getParameter("image2");
//        String image3 = request.getParameter("image3");
//        String image4 = request.getParameter("image4");
//        String image5 = request.getParameter("image5");
//        String accessories = request.getParameter("accessories");
//        String guaranty = request.getParameter("guaranty");
//        ProductEntity product = productDAO.getProduct(name, image);
//        Integer productId = product.getProductId();
//        productDetailDAO.
//                insertProductDetail(productId, information, fileName, image2, image3, image4, image5,
//                        accessories, guaranty);
//        response.sendRedirect("form.jsp?mess=" + mess); //To change body of generated methods, choose Tools | Templates.
//    }
//
//}
