<%-- 
    Document   : checkout
    Created on : Dec 17, 2019, 12:22:52 PM
    Author     : thai.nv173359
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<!DOCTYPE HTML>
<html>
    <head>
        <title>15Tech Shop| Giỏ hàng</title>
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
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="check">	 
                <div class="col-md-9 cart-items">
                    <h1>Giỏ hàng của tôi </h1>

                    <script>$(document).ready(function (c) {
                            $('.close1').on('click', function (c) {
                                $('.cart-header1').fadeOut('slow', function (c) {
                                    $('.cart-header1').remove();
                                });
                            });
                        });
                    </script>
                    <script>$(document).ready(function (c) {
                            $('.close2').on('click', function (c) {
                                $('.cart-header2').fadeOut('slow', function (c) {
                                    $('.cart-header2').remove();
                                });
                            });
                        });
                    </script>
                    <script>$(document).ready(function (c) {
                            $('.close3').on('click', function (c) {
                                $('.cart-header3').fadeOut('slow', function (c) {
                                    $('.cart-header3').remove();
                                });
                            });
                        });
                    </script>
                    <c:forEach items="${listProduct}" var="product">

                        <div class="cart-header">
                            <a href="Cart?product_id=${product.productId}&delete=delete"><div class="close" style="background: url('images/close_1.png') no-repeat 0px 0px;
                                                                                              cursor: pointer;
                                                                                              width: 28px;
                                                                                              height: 28px;
                                                                                              position: absolute;
                                                                                              right: 0px;
                                                                                              top: 0px;
                                                                                              -webkit-transition: color 0.2s ease-in-out;
                                                                                              -moz-transition: color 0.2s ease-in-out;
                                                                                              -o-transition: color 0.2s ease-in-out;
                                                                                              transition: color 0.2s ease-in-out;" > 
                                </div></a>
                            <div class="cart-sec simpleCart_shelfItem">
                                <div class="cart-item cyc">
                                    <a href="viewSingleProduct?productId=${product.productId}"><img src="${product.thumbImage}" class="img-responsive" alt="" ></a>
                                </div>
                                <div class="cart-item-info">
                                    <h3><a href="viewSingleProduct?productId=${product.productId}">${product.name} </a>
                                        <a href="searchbrand?brand=${product.brand}&category_id=${product.categoryId}"><span>Hãng ${product.brand} </span></a>
                                    </h3>
                                    <ul class="qty">
                                        <li><p></p></li>
                                        <li><p>Số lượng : 1</p></li>
                                    </ul>
                                    <div class="delivery">
                                        <p>Giá : <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" /></p>

                                        <div class="clearfix"></div>
                                    </div>	
                                </div>
                                <div class="clearfix"></div>

                            </div>
                        </div>

                    </c:forEach>



                </div>
                <div class="col-md-3 cart-total">
                    <a class="continue" href="index">Tiếp tục mua sắm </a>
                    <div class="price-details">
                        <h3>Thanh toán </h3>
                        <span>Tổng giá tiền </span>
                        <span class="total1"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${tong}" /></span>
                        <span>Giảm giá 0% </span>
                        <span class="total1">---</span>
                        <span>Tổng tiền được giảm </span>
                        <span class="total1">0</span>
                        <div class="clearfix"></div>				 
                    </div>	
                    <ul class="total_price">
                        <li class="last_price"> <h4>Thành tiền </h4></li>	
                        <li class="last_price"><span><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${tong}" /></span></li>
                        <div class="clearfix"> </div>
                    </ul>

                    <div class="clearfix"></div>
                    <c:if test="${user ne null}">
                        <a class="order" href="purchase.jsp?id=${user.customerId}">Đặt mua </a>
                    </c:if>
                    <c:if test="${user eq null}">
                        <a class="order" href="login.jsp">Đặt mua </a>
                    </c:if>                   
                    <div class="total-item">
                        <h3>Lựa chọn thanh toán </h3>
                        <h4>Mã giảm giá </h4>
                        <a class="cpns" href="#">Xác nhận </a>
                        <p><a href="#">Phương thức giao hàng:</a>Giao hàng nhanh (3-4 ngày) </p>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>	
    </body>
</html>		