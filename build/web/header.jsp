<%@page import="com.banana.entity.CustomerEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <script src="js/simpleCart.min.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/sownindex.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
    </head>
    <body>


        <div class="header_top">
            <div class="container">
                <div class="cssmenu">
                    <ul>
                        <c:choose>
                            <c:when test="${status=='success'}">
                                <li class="active"><a href="customer.jsp?id=${user.customerId}">${user.name}</a><a href="Logout" style="margin-left: 20px;">Đăng xuất</a></li>
                                    </c:when>
                                    <c:otherwise>
                                <li class="active"><a href="login.jsp">Đăng nhập</a></li>
                                </c:otherwise>
                            </c:choose> 
                    </ul>
                </div>
            </div>
        </div>
        <div class="wrap-box"></div>
        <div class="header_bottom">
            <div class="container">
                <div class="col-xs-8 header-bottom-left">
                    <div class="col-xs-2 logo">
                        <h1><a href="index"><span>FIFteen</span>Technology</a></h1>
                    </div>
                    <div class="col-xs-6 menu">
                        <ul class="megamenu skyblue">
                            <li class="active grid"><a class="color1" href="#laptop">Laptop</a><div class="megapanel">
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <ul>
                                                    <h4>Thương Hiệu</h4>
                                                    <li><a href="searchbrand?brand=asus&category_id=1">ASUS</a></li>
                                                    <li><a href="searchbrand?brand=dell&category_id=1">DELL</a></li>
                                                    <li><a href="searchbrand?brand=acer&category_id=1">ACER</a></li>
                                                    <li><a href="searchbrand?brand=apple&category_id=1">APPLE</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Giá</h4>
                                                <ul>
                                                    <li><a href="searchprice?max_price=10000000&category_id=1&order=ASC"> < 10m</a></li>
                                                    <li><a href="searchprice?min_price=10000000&max_price=15000000&category_id=1&order=ASC">10m - 15m</a></li>
                                                    <li><a href="searchprice?min_price=15000000&max_price=20000000&category_id=1&order=ASC">15m - 20m</a></li>
                                                    <li><a href="searchprice?min_price=20000000&category_id=1&order=ASC"> > 20m</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Phụ kiện </h4>
                                                <ul>
                                                    <li><a href="men.html">Tai nghe</a></li>
                                                    <li><a href="men.html">Chuột lap top</a></li>
                                                    <li><a href="men.html"></a>Bàn Phím</li>
                                                    <li><a href="men.html">Ổ cứng</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li class="grid"><a class="color2" href="#phone">Điện Thoại</a>
                                <div class="megapanel">
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Thương hiệu</h4>
                                                <ul>
                                                    <li><a href="searchbrand?brand=apple&category_id==2">APPLE</a></li>
                                                    <li><a href="searchbrand?brand=xiaomi&category_id==2">XIAOMI</a></li>
                                                    <li><a href="searchbrand?brand=asus&category_id=2">ASUS</a></li>
                                                    <li><a href="searchbrand?brand=sony&category_id==2">SONY</a></li>
                                                    <li><a href="searchbrand?brand=samsung&category_id==2">SAMSUNG</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Giá</h4>
                                                <ul>
                                                    <li><a href="searchprice?max_price=2000000&category_id=2&order=ASC"> < 2m</a></li>
                                                    <li><a href="searchprice?min_price=2000000&max_price=4000000&category_id=2&order=ASC">2m - 4m</a></li>
                                                    <li><a href="searchprice?min_price=4000000&max_price=6000000&category_id=2&order=ASC">4m - 6m</a></li>
                                                    <li><a href="searchprice?min_price=6000000&max_price=10000000&category_id=2&order=ASC">6m - 10m</a></li>
                                                    <li><a href="searchprice?min_price=10000000&category_id=2&order=ASC"> > 10m</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col1">
                                            <div class="h_nav">
                                                <h4>Phụ kiện điện thoại</h4>
                                                <ul>
                                                    <li><a href="men.html">Tai Nghe</a></li>
                                                    <li><a href="men.html">Cáp sạc - Pin</a></li>
                                                    <li><a href="men.html">Sạc dự phòng</a></li>

                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <li><a class="color4" href="#acc">Phụ kiện </a></li>
<!--                            <li><a class="color5" href="404.html">Bài viết </a></li>-->
                            <li><a class="color6" href="https://fb.me/SownChuoois">Liên hệ - Hỗ Trợ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-xs-4 header-bottom-right">
                    <div class="box_1-cart">
                        <div class="box_11"><a href="cart.jsp">
                                <h4><p>Giỏ Hàng: <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</p><img src="images/bag.png" alt=""/><div class="clearfix"> </div></h4>
                            </a></div>

                        <div class="clearfix"> </div>
                    </div>
                    <form class="search" action = "search">
                        <input type="text" name="s" class="textbox" value="Tìm kiếm" onfocus="this.value = '';" onblur="if (this.value == '') {
                                    this.value = 'Tìm kiếm ';
                                }" <%--pattern="[a-z]{1,200}"--%>>
                        <input type="submit" value="Subscribe" id="submit" name="submit">
                        <div id="response"> </div>
                    </form>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </body>
</html>
