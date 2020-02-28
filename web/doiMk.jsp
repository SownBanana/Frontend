<%--
  Created by IntelliJ IDEA.
  User: thai.nv173359
  Date: 12/8/2019
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.banana.dao.CustomerDAO"%>
<%@page import="com.banana.entity.CustomerLvEntity"%>
<%@page import="com.banana.dao.CustomerLvDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>15Tech Shop| Đổi mật khẩu</title>
        <link rel="SHORTCUT ICON" href="images/logo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <!-- Custom Theme files -->
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <script src="js/simpleCart.min.js"></script>
        <!-- Custom Theme files -->
        <!--webfont-->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <!-- start menu -->
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <%
            CustomerDAO customerDAO = new CustomerDAO();
            String email = request.getParameter("email");
            Integer phone = Integer.parseInt(request.getParameter("phone"));
            String mess = null;
            try {
                CustomerEntity customerEntity = customerDAO.getEmail(email);
                if (customerEntity.getPhone().equals(phone)) {

                } else {
                    mess = "Sai số điện thoại";
                }
            } catch (Exception e) {
                mess = "eMail không tồn tại";
            }

        %>
        <c:choose>
            <c:when test="${mess eq null}">
                <div class="single_top">
                    <div class="container">
                        <div class="register">
                            <div class="col-md-6 login-right">
                                <h3>Khách hàng đã có tài khoản </h3>
                                <p>Thực hiện đăng nhập ở form bên dưới.</p>
                                <form action="DoiMk?phone=<%=phone%>&mail=<%=email%>" method="post">
                                    <div>
                                        <span>Địa chỉ email :<label>*</label> <p style="color:#FA603D;"><%=email%></p> </span>

                                    </div>
                                    <div>
                                        <span>Số điện thoại xác nhận:<label>*</label> <p style="color:#FA603D;">0<%=phone%></p></span>

                                    </div>
                                    <div>
                                        <span>Nhập lại mật khẩu mới:<label>*</label></span>
                                        <input type="password" placeholder="Mật khẩu mới " name="pass">
                                    </div>

                                    <div>


                                    </div>
                                    <input type="submit" value="Đổi mật khẩu">
                                </form>
                            </div>
                            <div class="col-md-6 login-left">
                                <h3>Khách hàng mới </h3>
                                <p>Bằng cách tạo tài khoản với cửa hàng của chúng tôi, bạn sẽ có thể thực hiện thanh toán nhanh hơn, lưu trữ nhiều địa chỉ giao hàng, xem và theo dõi đơn hàng của bạn trong tài khoản của bạn và hơn thế nữa.</p>
                                <a class="acount-btn" href="register.jsp">Đăng kí tài khoản </a>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <div class="single_top">
                    <div class="container">
                        <span><p style="color:red;"><b>*<%=mess%></b></p></span>
                        <a href="quen-mk.jsp">Nhập lại</a>
                    </div>
                </div>

            </c:otherwise>
        </c:choose>
        <!--        <div class="single_top">
                    <div class="container">
                        <div class="register">
                            <div class="col-md-6 login-right">
                                <h3>Khách hàng đã có tài khoản </h3>
                                <p>Thực hiện đăng nhập ở form bên dưới.</p>
                                <form action="DoiMk?phone=<%=phone%>&mail=<%=email%>" method="post">
                                    <div>
                                        <span>Địa chỉ email :<label>*</label> <p style="color:#FA603D;"><%=email%></p> </span>
        
                                    </div>
                                    <div>
                                        <span>Số điện thoại xác nhận:<label>*</label> <p style="color:#FA603D;"><%=phone%></p></span>
        
                                    </div>
                                    <div>
                                        <span>Nhập lại mật khẩu mới:<label>*</label></span>
                                        <input type="text" placeholder="Mật khẩu mới " name="pass">
                                    </div>
        
                                    <div>
                                        <span><label>*</label> <p style="color:red;"><b><%=mess%></b></p></span>
        
                                    </div>
                                    <input type="submit" value="Đổi mật khẩu">
                                </form>
                            </div>
                            <div class="col-md-6 login-left">
                                <h3>Khách hàng mới </h3>
                                <p>Bằng cách tạo tài khoản với cửa hàng của chúng tôi, bạn sẽ có thể thực hiện thanh toán nhanh hơn, lưu trữ nhiều địa chỉ giao hàng, xem và theo dõi đơn hàng của bạn trong tài khoản của bạn và hơn thế nữa.</p>
                                <a class="acount-btn" href="register.jsp">Đăng kí tài khoản </a>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>-->
        <%@include file="footer.jsp"%>
    </body>
</html>