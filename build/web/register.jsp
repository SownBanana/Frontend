<%--
  Created by IntelliJ IDEA.
  User: thai.nv173359
  Date: 12/8/2019
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>

        <title>15Tech Shop| Đăng ký</title>
        <link rel="SHORTCUT ICON" href="images/logo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
        <%
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        %>
        <%@include file="header.jsp"%>
        <div class="single_top">
            <div class="container">
                <div class="register">
                    <form action="register" method="post">
                        <div class="register-top-grid">
                            <h3>THÔNG TIN KHÁCH HÀNG </h3>
                            <div>
                                <span>Tên khách hàng<label>*</label></span>
                                <input type="text" name="name">
                            </div>
                            <div>
                                <span>Số điện thoại<label>*</label></span>
                                <input type="text" name="phone">
                            </div>
                            <div>
                                <span>Địa chỉ <label>*</label></span>
                                <input type="text" name="address">
                            </div>
                            <div>
                                <span>Thành phố (Tỉnh) sinh sống <label>*</label></span>
                                <input type="text" name="cityRegion">
                            </div>
                            <div class="clearfix"> </div>
                            <a class="news-letter" href="#">
                                <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Đồng ý với điều khoản của chúng tôi </label>
                            </a>
                        </div>
                        <div class="register-bottom-grid">
                            <h3>THÔNG TIN ĐANG NHẬP</h3>
                            <div>
                                <span>Địa chỉ email<label>*</label></span>
                                <input type="text" name="email">
                            </div>
                            <div>
                                <span>Mật khẩu<label>*</label></span>
                                <input type="password" name="password">
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <input type="submit" value="Đăng ký" style="    background: #df1f26;
                               color: #FFF;
                               font-size: 0.8em;
                               padding: 0.8em 2em;
                               transition: 0.5s all;
                               -webkit-transition: 0.5s all;
                               -moz-transition: 0.5s all;
                               -o-transition: 0.5s all;
                               display: inline-block;
                               text-transform: uppercase;
                               border: none;
                               outline: none;">
                        <div class="clearfix"> </div>
                    </form>
                    <div class="clearfix"> </div>
                    <div class="register-but">

                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>