package com.banana.controller;

import com.banana.dao.ProductDAO;
import com.banana.entity.ProductEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {

    private static List<ProductEntity> productEntitys = new ArrayList<ProductEntity>();

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
            StringBuffer url = request.getRequestURL();
            int id = 0;
            try {
                id = Integer.parseInt(request.getParameter("product_id"));
            } catch (Exception e) {
                e.printStackTrace();
                productEntitys = null;
                request.getSession().setAttribute("tong", 0);
                request.getSession().setAttribute("listProduct", productEntitys);
                response.sendRedirect("cart.jsp");
            }
            String isDelete = request.getParameter("delete");
            if (!"delete".equals(isDelete)) {
                ProductDAO productDAO = new ProductDAO();
                double tong = 0;
                request.getSession().removeAttribute("listProduct");
                productEntitys.add(productDAO.getProduct(id));
                for (ProductEntity productEntity : productEntitys) {
                    tong += productEntity.getPrice();
                }
                request.getSession().setAttribute("tong", tong);
                request.getSession().setAttribute("listProduct", productEntitys);
                if (request.getParameter("url") != null) {
                    String urlr = request.getParameter("url");
                    response.sendRedirect(urlr);
                } else {
                    response.sendRedirect("index");
                }
            } else {
                ProductDAO productDAO = new ProductDAO();
                double tong = 0;
                request.getSession().removeAttribute("listProduct");
                productEntitys.remove(productDAO.getProduct(id));
                for (ProductEntity productEntity : productEntitys) {
                    tong += productEntity.getPrice();
                }
                request.getSession().setAttribute("tong", tong);
                request.getSession().setAttribute("listProduct", productEntitys);
                response.sendRedirect("cart.jsp");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
