/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banana.controller;

import com.banana.dao.ProductDAO;
import com.banana.dao.ProductDetailDAO;
import com.banana.entity.ProductEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author SownBanana
 */
@WebServlet(name = "addProductServlet", urlPatterns = {"/admin/addProduct"})
@MultipartConfig(maxFileSize = 16177215)
public class addProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String descriptionDetail = request.getParameter("description_detail");
//        String image = request.getParameter("image");
        Integer categoryID = Integer.parseInt(request.getParameter("categoryId"));
        String brand = request.getParameter("brand");

        //xử lý file
        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path = "P:/emarket155/web/images/" + fileName;
        String fileURL = "images/" + fileName;
        try {
            InputStream fileContent = filePart.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            File targetFile = new File(path);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println(productDAO.insertProduct(name, price, description, descriptionDetail, fileURL, fileURL,
                categoryID, brand));

        String information = request.getParameter("information");
        String[] fileURLs = new String[6];
        for (int i = 1; i <= 5; i++) {
            Part image = request.getPart("image" + i);
            fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            path = "P:/emarket155/web/images/" + fileName;
            fileURLs[i] = "images/" + fileName;
            try {
                InputStream fileContent = image.getInputStream();
                byte[] buffer = new byte[fileContent.available()];
                fileContent.read(buffer);
                File targetFile = new File(path);
                OutputStream outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        String accessories = request.getParameter("accessories");
        String guaranty = request.getParameter("guaranty");
        ProductEntity product = productDAO.getProduct(description);
        Integer productId = productDAO.getProductId();
        System.out.println(productDetailDAO.insertProductDetail(productId, information, fileURLs[1], fileURLs[2], fileURLs[3], fileURLs[4],
                fileURLs[5],
                accessories, guaranty));
        response.sendRedirect("form.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String descriptionDetail = request.getParameter("description_detail");
//        String image = request.getParameter("image");
        Integer categoryID = Integer.parseInt(request.getParameter("categoryId"));
        String brand = request.getParameter("brand");

        //xử lý file
        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path = "P:/emarket155/web/images/" + fileName;
        String fileURL = "images/" + fileName;
        try {
            InputStream fileContent = filePart.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            File targetFile = new File(path);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println(productDAO.insertProduct(name, price, description, descriptionDetail, fileURL, fileURL,
                categoryID, brand));

        String information = request.getParameter("information");
        String[] fileURLs = new String[6];
        for (int i = 1; i <= 5; i++) {
            Part image = request.getPart("image" + i);
            fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            path = "P:/emarket155/web/images/" + fileName;
            fileURLs[i] = "images/" + fileName;
            try {
                InputStream fileContent = image.getInputStream();
                byte[] buffer = new byte[fileContent.available()];
                fileContent.read(buffer);
                File targetFile = new File(path);
                OutputStream outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        String accessories = request.getParameter("accessories");
        String guaranty = request.getParameter("guaranty");
        ProductEntity product = productDAO.getProduct(description);
        Integer productId = productDAO.getProductId();
        System.out.println(productDetailDAO.insertProductDetail(productId, information, fileURLs[1], fileURLs[2], fileURLs[3], fileURLs[4],
                fileURLs[5],
                accessories, guaranty));
        response.sendRedirect("form.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String descriptionDetail = request.getParameter("description_detail");
//        String image = request.getParameter("image");
        Integer categoryID = Integer.parseInt(request.getParameter("categoryId"));
        String brand = request.getParameter("brand");

        //xử lý file
        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="image">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        String path = "P:/emarket155/web/images/" + fileName;
        String fileURL = "images/" + fileName;
        try {
            InputStream fileContent = filePart.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            File targetFile = new File(path);
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        System.out.println(productDAO.insertProduct(name, price, description, descriptionDetail, fileURL, fileURL,
                categoryID, brand));

        String information = request.getParameter("information");
        String[] fileURLs = new String[6];
        for (int i = 1; i <= 5; i++) {
            Part image = request.getPart("image" + i);
            fileName = Paths.get(image.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            path = "P:/emarket155/web/images/" + fileName;
            fileURLs[i] = "images/" + fileName;
            try {
                InputStream fileContent = image.getInputStream();
                byte[] buffer = new byte[fileContent.available()];
                fileContent.read(buffer);
                File targetFile = new File(path);
                OutputStream outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        String accessories = request.getParameter("accessories");
        String guaranty = request.getParameter("guaranty");
        ProductEntity product = productDAO.getProduct(description);
        Integer productId = productDAO.getProductId();
        System.out.println(productDetailDAO.insertProductDetail(productId, information, fileURLs[1], fileURLs[2], fileURLs[3], fileURLs[4],
                fileURLs[5],
                accessories, guaranty));
        response.sendRedirect("form.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
