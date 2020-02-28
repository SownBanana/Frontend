package com.banana.controller;

import com.banana.dao.CustomerDAO;
import com.banana.entity.CustomerEntity;
import com.banana.service.MaSHA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
@WebServlet(name = "DoiUser", urlPatterns = {"/DoiUser"})
public class DoiUser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        CustomerDAO customerDAO = new CustomerDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerEntity customer = customerDAO.getIdCustomer(id);
        String address = customer.getAddress();
        String cityRegion = customer.getCityRegion();
        String pass = request.getParameter("password");
        String pass1 = request.getParameter("password1");
        int phone = customer.getPhone();
        String name = customer.getName();
        try {
            address = request.getParameter("address");
            cityRegion = request.getParameter("cityRegion");
            phone = Integer.parseInt(request.getParameter("phone"));
            name = request.getParameter("name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (MaSHA.sha256(pass1).equals(customer.getPassword())) {
            if (address != null && address.length() > 1) {
                customer.setAddress(address);
            } else {
                customer.setAddress(customer.getAddress());
            }
            if (pass.length() > 1) {
                customer.setPassword(MaSHA.sha256(pass));
            } else {
                customer.setPassword(customer.getPassword());
            }
            if (cityRegion.length() > 1) {
                customer.setCityRegion(cityRegion);
            } else {
                customer.setCityRegion(customer.getCityRegion());
            }
            if (phone > 10000000) {
                customer.setPhone(phone);
            } else {
                customer.setPhone(customer.getPhone());
            }
            if (name.length() > 1) {
                customer.setName(name);
            } else {
                customer.setName(customer.getName());
            }

            customerDAO.updateUser(customer);
            response.sendRedirect("customer.jsp?id=" + id + "&" + "mess1=1");
        } else {
            response.sendRedirect("formUser.jsp?id=" + id + "&" + "mess1=1");
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
