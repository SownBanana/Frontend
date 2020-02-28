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
@WebServlet(name = "searchByBrandAnCategoryServlet", urlPatterns = {"/searchbrand"})
public class searchByBrandAnCategoryServlet extends HttpServlet {

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
            out.println("<title>Servlet searchByBrandAnCategoryServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchByBrandAnCategoryServlet at " + request.getContextPath() + "</h1>");
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
        ProductDAO productDAO = new ProductDAO();
        int page = 1;
        int recordsPerPage = 12;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        String brand = request.getParameter("brand");

        if (request.getParameter("category_id") != null) {
            Integer categoryId = Integer.parseInt(request.getParameter("category_id"));
            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
                    brand, categoryId);
            int noOfRecords = productDAO.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("products", products);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("header", brand);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        } else {
            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
                    brand);
            int noOfRecords = productDAO.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("products", products);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("header", brand);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        }
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
        ProductDAO productDAO = new ProductDAO();
        int page = 1;
        int recordsPerPage = 12;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        String brand = request.getParameter("brand");

        if (request.getParameter("category_id") != null) {
            Integer categoryId = Integer.parseInt(request.getParameter("category_id"));
            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
                    brand, categoryId);
            int noOfRecords = productDAO.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("products", products);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("header", brand);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        } else {
            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
                    brand);
            int noOfRecords = productDAO.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("products", products);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("header", brand);
            RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
            dispatcher.forward(request, response);
        }
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
