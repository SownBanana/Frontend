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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thai.nv173359
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        String password = MaSHA.sha256(pass);
        CustomerDAO customerDAO = new CustomerDAO();
        String mess = "";
        if (customerDAO.getEmailCustomer(email, password).getName() != null) {
            CustomerEntity customer = customerDAO.getEmailCustomer(email, password);
            HttpSession session = request.getSession();
//            Cookie cookie = request.getCookies()
            if (email.equals("admin")) {
                session.setAttribute("admin", email);
                response.sendRedirect("admin/index.jsp");
            }
            if (customer.getLevel() >= 0) {
                session.setAttribute("user", customer);
                session.setAttribute("status", "success");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index");
                dispatcher.forward(request, response);
            } else {
                mess = "Tài khoản của bạn đã bị khoá!";
            }

        } else {
            mess = "Bạn đã nhập sai eMail hoặc mật khẩu!";
        }
        request.setAttribute("mess", mess);
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
