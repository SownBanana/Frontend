/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banana.controller;

import com.banana.dao.ProductDAO;
import com.banana.dao.ProductDetailDAO;
import com.banana.entity.ProductDetailEntity;
import com.banana.entity.ProductEntity;
//import com.banana.dao.ProductDAO;
//import com.banana.dao.ProductDetailDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SownBanana
 */
@WebServlet(name = "viewSingleProduct", urlPatterns = {"/viewSingleProduct"})
public class viewSingleProduct extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet viewSingleProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewSingleProduct at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        ProductDAO productDAO = new ProductDAO();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        ProductEntity product = productDAO.getProduct(productId);
        ProductDetailEntity productDetail = productDetailDAO.getProductDetail(productId);
        List<ProductEntity> relatedProduct = productDAO.viewAllProductByCategory(0, 5, product.getCategoryId());
        List<ProductEntity> sameBrandProduct = productDAO.viewAllProductByBrand(0, 99, product.getBrand());
        relatedProduct.remove(product);
        sameBrandProduct.remove(product);
        Collections.shuffle(sameBrandProduct);
        request.setAttribute("productDetail", productDetail);
        request.setAttribute("product", product);
        request.setAttribute("relatedProduct", relatedProduct);
        if (sameBrandProduct.size() > 4) {
            request.setAttribute("sameBrand", sameBrandProduct.subList(0, 4));

        } else {
            request.setAttribute("sameBrand", sameBrandProduct);

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("single.jsp");
        requestDispatcher.forward(request, response);
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

        Integer productId = Integer.parseInt(request.getParameter("productId"));
        ProductDAO productDAO = new ProductDAO();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        ProductEntity product = productDAO.getProduct(productId);
        ProductDetailEntity productDetail = productDetailDAO.getProductDetail(productId);
        List<ProductEntity> relatedProduct = productDAO.viewAllProductByCategory(0, 4, 1);
        List<ProductEntity> sameBrandProduct = productDAO.viewAllProductByBrand(0, 5, product.getBrand());
        relatedProduct.remove(product);
        sameBrandProduct.remove(product);
        request.setAttribute("productDetail", productDetail);
        request.setAttribute("product", product);
        request.setAttribute("relatedProduct", relatedProduct);
        if (sameBrandProduct.size() > 4) {
            request.setAttribute("sameBrand", sameBrandProduct.subList(0, 4));

        } else {
            request.setAttribute("sameBrand", sameBrandProduct);

        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("single.jsp");
        requestDispatcher.forward(request, response);

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
