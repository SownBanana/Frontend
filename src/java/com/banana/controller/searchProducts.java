/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banana.controller;

import com.banana.dao.ProductDAO;
import com.banana.entity.ProductEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
@WebServlet(name = "searchProducts", urlPatterns = {"/search"})
public class searchProducts extends HttpServlet {

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
            out.println("<title>Servlet searchProducts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchProducts at " + request.getContextPath() + "</h1>");
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
        int page = 1;
        int recordsPerPage = 12;
        if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        String key = request.getParameter("s");
        ProductDAO productDAO = new ProductDAO(); 
        List<ProductEntity> productsName = productDAO.viewAllProductByName((page -1)*recordsPerPage, recordsPerPage, key);
        List<ProductEntity> products = productDAO.searchProduct((page - 1)*recordsPerPage, recordsPerPage, key);
        productsName.addAll(products);
        Set<ProductEntity> set = new LinkedHashSet<>(productsName);
        List<ProductEntity> rs = new ArrayList<>(set);
        if(rs.size() > 12){
            List<ProductEntity> productEntitys = rs.subList(0, recordsPerPage);
        }
        List<ProductEntity> productEntitys = rs;
        int noOfRecords = productDAO.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("products", productEntitys);
        request.setAttribute("header", "Tìm kiếm");
        request.setAttribute("search", key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
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
        int page = 1;
        int recordsPerPage = 12;
        if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

         String key = request.getParameter("s");
        ProductDAO productDAO = new ProductDAO(); 
        List<ProductEntity> productsName = productDAO.viewAllProductByName((page -1)*recordsPerPage, recordsPerPage, key);
        List<ProductEntity> products = productDAO.searchProduct((page - 1)*recordsPerPage, recordsPerPage, key);
        productsName.addAll(products);
        Set<ProductEntity> set = new LinkedHashSet<>(productsName);
        List<ProductEntity> rs = new ArrayList<>(set);
        if(rs.size() > 12){
            List<ProductEntity> productEntitys = rs.subList(0, recordsPerPage);
        }
        List<ProductEntity> productEntitys = rs;
        int noOfRecords = productDAO.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("products", productEntitys);
        request.setAttribute("header", "Tìm kiếm");
        request.setAttribute("search", key);
        RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
        dispatcher.forward(request, response);
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
