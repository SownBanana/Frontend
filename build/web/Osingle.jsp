<%@page import="com.banana.entity.ProductDetailEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.banana.entity.ProductEntity" %><%--
  Created by IntelliJ IDEA.
  User: SownBanana
  Date: 12/14/2019
  Time: 11:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy_shop an E-Commerce online Shopping Category Flat Bootstarp responsive Website Template| Single :: w3layouts</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <!-- Custom Theme files -->
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <script src="js/simpleCart.min.js"> </script>
    <!-- Custom Theme files -->
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <!-- start menu -->
    <script src="js/jquery.easydropdown.js"></script>
    <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="js/megamenu.js"></script>
    <script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
    <link rel="stylesheet" href="css/etalage.css">
    <script src="js/jquery.etalage.min.js"></script>
    <script>
        jQuery(document).ready(function($){

            $('#etalage').etalage({
                thumb_image_width: 300,
                thumb_image_height: 400,
                source_image_width: 900,
                source_image_height: 1200,
                show_hint: true,
                click_callback: function(image_anchor, instance_id){
                    alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
                }
            });

        });
    </script>
    <!--initiate accordion-->
    <script type="text/javascript">
        $(function() {

            var menu_ul = $('.menu_drop > li > ul'),
                menu_a  = $('.menu_drop > li > a');

            menu_ul.hide();

            menu_a.click(function(e) {
                e.preventDefault();
                if(!$(this).hasClass('active')) {
                    menu_a.removeClass('active');
                    menu_ul.filter(':visible').slideUp('normal');
                    $(this).addClass('active').next().stop(true,true).slideDown('normal');
                } else {
                    $(this).removeClass('active');
                    $(this).next().stop(true,true).slideUp('normal');
                }
            });

        });
    </script>
</head>
<body>


<div class="single_top">
<%--<c:forEach var="product" items="${product}">--%>
<%--<c:forEach var="productDetail" items="${productDetail}" >--%>


    <% ProductEntity product = (ProductEntity) request.getAttribute("product"); %>
    <% ProductDetailEntity productDetail = (ProductDetailEntity) request.getAttribute("productDetail"); %>
    <div class="container">
        <div class="single_grid">
            <div class="grid images_3_of_2">
                <ul id="etalage">
                    <li>
                        <a href="optionallink.html">
                            <img class="etalage_thumb_image" src="${productDetail.image1}" class="img-responsive" />
                            <img class="etalage_source_image" src="${productDetail.image1}" class="img-responsive"
                                 title="" />
                        </a>
                    </li>
                    <li>
                        <img class="etalage_thumb_image" src="${productDetail.image2}" class="img-responsive" />
                        <img class="etalage_source_image" src="${productDetail.image2}" class="img-responsive" title="" />
                    </li>
                    <li>
                        <img class="etalage_thumb_image" src="${productDetail.image3}" class="img-responsive"  />
                        <img class="etalage_source_image" src="${productDetail.image3}"class="img-responsive"  />
                    </li>
                    <li>
                        <img class="etalage_thumb_image" src="${productDetail.image4}" class="img-responsive"  />
                        <img class="etalage_source_image" src="${productDetail.image4}"class="img-responsive"  />
                    </li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="desc1 span_3_of_2">
                <ul class="back">
                    <li><i class="back_arrow"> </i>Back to <a href="index.html">Laptop</a></li>
                </ul>
                <h1>${product.name}</h1>
                <p>${product.description}</p>
<%----%>
                <div class="simpleCart_shelfItem">
                    <div class="price_single">
                        <div class="head"><h2><span class="amount item_price">${product.price} đồng</span></h2></div>
                        <div class="head_desc"><a href="#">12 reviews</a><img src="images/review.png" alt=""/></div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="size_2-right"><a href="#" class="item_add item_add1 btn_5" value="" />Thêm vào giỏ hàng
                        </a>
                    </div>

                </div>
            </div>
            <div class="clearfix"></div>
        </div>

        <ul class="menu_drop">
            <li class="item1"><a href="#"><img src="images/product_arrow.png">Mô tả chỉ tiết</a>
                <ul>
                    <li class="subitem1">${product.descriptionDetail}</li>
                                    </ul>
            </li>
            <li class="item2"><a href="#"><img src="images/product_arrow.png">Thông tin</a>
                <ul>
                    <li class="subitem2">${productDetail.information}</li>
                </ul>
            </li>
        </ul>
    </div>
    <h3 class="m_2">Sản phẩm liên quan</h3>
    <div class="container">
        <div class="box_3">
            <c:forEach var="sproduct" items="${relatedProduct}">
            <div class="col-md-3">
                <div class="content_box"><a href="viewSingleProduct?productId = ${sproduct.productId}">
                    <img src="${sproduct.thumbImage}" class="img-responsive" alt="">
                </a>
                </div>
                <h4><a href="viewSingleProduct?productId = ${sproduct.productId}">${sproduct.name}</a></h4>
                <p>${sproduct.price}</p>
            </div>
            <div class="clearfix"> </div>
            </c:forEach>
        </div>
    </div>
</div>
<%--</c:forEach>--%>
<%--</c:forEach>--%>
</body>
</html>
