/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author thai.nv173359
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String name =request.getParameter("name");
        String address = request.getParameter("address");
        Integer phone = Integer.parseInt(request.getParameter("phone").replaceFirst("0", "")) ;
        String cityReagion = request.getParameter("cityReagion");
        String pass = request.getParameter("password");
        String password = MaSHA.sha256(pass);
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCityRegion(cityReagion);
        customer.setPassword(password);
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.addCutomer(customer);
        response.sendRedirect("login.jsp");
    }
}
