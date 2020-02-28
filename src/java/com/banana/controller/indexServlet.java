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
import javax.servlet.http.HttpSession;

/**
 *
 * @author SownBanana
 */
@WebServlet(name = "indexServlet", urlPatterns = {"/index"}, loadOnStartup = -1)
public class indexServlet extends HttpServlet {

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
            out.println("<title>Servlet indexServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet indexServlet at " + request.getContextPath() + "</h1>");
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
        int pageLap = 1;
        int pagePhone = 1;
        int pageAcc = 1;
        int recordsPerPage = 8;
        String jump = "";
        if (request.getParameter("jump") != null) {
            jump = "#" + request.getParameter("jump");
        }
        if (request.getParameter("pageLap") != null) {
            pageLap = Integer.parseInt(request.getParameter("pageLap"));
        }
        if (request.getParameter("pagePhone") != null) {
            pagePhone = Integer.parseInt(request.getParameter("pagePhone"));
        }
        if (request.getParameter("pageAcc") != null) {
            pageAcc = Integer.parseInt(request.getParameter("pageAcc"));
        }
        int noOfRecords;
        ProductDAO productDAO = new ProductDAO();
        List<ProductEntity> productsLap = productDAO.viewAllProductByCategory((pageLap - 1) * recordsPerPage, recordsPerPage,
                1);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesLap = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        List<ProductEntity> productsPhone = productDAO.viewAllProductByCategory((pagePhone - 1) * recordsPerPage, recordsPerPage,
                2);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesPhone = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        List<ProductEntity> productsAcc = productDAO.viewAllProductByCategory((pageAcc - 1) * recordsPerPage/2, recordsPerPage/2,
                3);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesAcc = (int) Math.ceil(noOfRecords * 1.0 / (recordsPerPage/2));
//        HttpSession session = request.getSession();
        request.setAttribute("productsLap", productsLap);
        request.setAttribute("productsPhone", productsPhone);
        request.setAttribute("productsAcc", productsAcc);
        request.setAttribute("noOfPagesLap", noOfPagesLap);
        request.setAttribute("currentPageLap", pageLap);
        request.setAttribute("noOfPagesPhone", noOfPagesPhone);
        request.setAttribute("currentPagePhone", pagePhone);
        request.setAttribute("noOfPagesAcc", noOfPagesAcc);
        request.setAttribute("currentPageAcc", pageAcc);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp" + jump);
        requestDispatcher.forward(request, response);
//        response.sendRedirect("index.jsp#phone");
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
        int pageLap = 1;
        int pagePhone = 1;
        int pageAcc = 1;
        int recordsPerPage = 8;
        String jump = "";
        if (request.getParameter("jump") != null) {
            jump = "#" + request.getParameter("jump");
        }
        if (request.getParameter("pageLap") != null) {
            pageLap = Integer.parseInt(request.getParameter("pageLap"));
        }
        if (request.getParameter("pagePhone") != null) {
            pagePhone = Integer.parseInt(request.getParameter("pagePhone"));
        }
        if (request.getParameter("pageAcc") != null) {
            pageAcc = Integer.parseInt(request.getParameter("pageAcc"));
        }
        int noOfRecords;
        ProductDAO productDAO = new ProductDAO();
        List<ProductEntity> productsLap = productDAO.viewAllProductByCategory((pageLap - 1) * recordsPerPage, recordsPerPage,
                1);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesLap = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        List<ProductEntity> productsPhone = productDAO.viewAllProductByCategory((pagePhone - 1) * recordsPerPage, recordsPerPage,
                2);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesPhone = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        List<ProductEntity> productsAcc = productDAO.viewAllProductByCategory((pageAcc - 1) * recordsPerPage/2, recordsPerPage/2,
                3);
        noOfRecords = productDAO.getNoOfRecords();
        int noOfPagesAcc = (int) Math.ceil(noOfRecords * 1.0 / (recordsPerPage/2));
//        HttpSession session = request.getSession();
        request.setAttribute("productsLap", productsLap);
        request.setAttribute("productsPhone", productsPhone);
        request.setAttribute("productsAcc", productsAcc);
        request.setAttribute("noOfPagesLap", noOfPagesLap);
        request.setAttribute("currentPageLap", pageLap);
        request.setAttribute("noOfPagesPhone", noOfPagesPhone);
        request.setAttribute("currentPagePhone", pagePhone);
        request.setAttribute("noOfPagesAcc", noOfPagesAcc);
        request.setAttribute("currentPageAcc", pageAcc);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp" + jump);
        requestDispatcher.forward(request, response);
//        response.sendRedirect("index.jsp#phone");
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
