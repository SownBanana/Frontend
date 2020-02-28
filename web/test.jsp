<%-- 
    Document   : test
    Created on : Dec 14, 2019, 9:46:39 PM
    Author     : SownBanana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.banana.entity.ProductDetailEntity"%>
<%@page import="com.banana.entity.ProductEntity"%>
<%@page import="com.banana.entity.ProductEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:forEach var ="products" items="${productsLap}">
            <p>${products.name}</p>
        </c:forEach>
    </body>
</html>
