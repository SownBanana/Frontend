<%-- 
    Document   : aproduct
    Created on : Dec 14, 2019, 2:00:03 PM
    Author     : SownBanana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.banana.entity.ProductDetailEntity"%>
<%@page import="com.banana.entity.ProductEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>15Tech Shop| ${product.name}</title>
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
        <script src="js/jquery.easydropdown.js"></script>
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <link rel="stylesheet" href="css/etalage.css">
        <script src="js/jquery.etalage.min.js"></script>
        <script>
            jQuery(document).ready(function ($) {

                $('#etalage').etalage({
                    thumb_image_width: 400,
                    thumb_image_height: 400,
                    source_image_width: 900,
                    source_image_height: 1200,
                    show_hint: true,
                    click_callback: function (image_anchor, instance_id) {
                        alert('Callback example:\nYou clicked on an image with the anchor: "' + image_anchor + '"\n(in Etalage instance: "' + instance_id + '")');
                    }
                });

            });
        </script>
        <!--initiate accordion-->
        <script type="text/javascript">
            $(function () {

                var menu_ul = $('.menu_drop > li > ul'),
                        menu_a = $('.menu_drop > li > a');

                menu_ul.hide();

                menu_a.click(function (e) {
                    e.preventDefault();
                    if (!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true, true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true, true).slideUp('normal');
                    }
                });

            });
        </script>
    </head>

    <body>
        <%@include file = "header.jsp" %>
        <% ProductEntity product = (ProductEntity) request.getAttribute("product");%>
        <% ProductDetailEntity productDetail = (ProductDetailEntity) request.getAttribute("productDetail");%>
        <div class="single_top">
            <div class="container"> 
                <div class="single_grid">
                    <div class="grid images_3_of_2">
                        <ul id="etalage">
                            <li>
                                <a href="optionallink.html">
                                    <img class="etalage_thumb_image" src="${productDetail.image1}" class="img-responsive" />
                                    <img class="etalage_source_image" src="${productDetail.image1}" class="img-responsive" title="" />
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
                            <li>
                                <img class="etalage_thumb_image" src="${productDetail.image5}" class="img-responsive"  />
                                <img class="etalage_source_image" src="${productDetail.image5}"class="img-responsive"  />
                            </li>
                        </ul>
                        <div class="clearfix"></div>		
                    </div> 
                    <div class="desc1 span_3_of_2">
                        <ul class="back">
                            <li><i class="back_arrow"> </i><a href="index.html">Trở lại</a></li>
                        </ul>
                        <h1>${product.description}</h1>
                        <p>${product.descriptionDetail}</p>
                        <div class="dropdown_top">
                            <div class="dropdown_left">
                                <select class="dropdown" tabindex="10" data-settings='{"wrapperClass":"metro1"}'>
                                    <option value="0">Cấu hình</option>	
                                    <option value="1">4GB - 1T HDD</option>
                                    <option value="2">4GB - 128GB SSD</option>
                                    <option value="3">8GB - 512GB SSD</option>
                                    <option value="4">16GB - 512GB SSD</option>
                                    <option value="5">32GB - 1T SSD </option>
                                    <option value="5"></option>
                                    <option value="5"></option>
                                </select>
                            </div>
                            <ul class="color_list">
                                <li><a href=""> <span class="color1"> </span></a></li>
                                <li><a href=""> <span class="color2"> </span></a></li>
                                <li><a href=""> <span class="color3"> </span></a></li>
                                <li><a href=""> <span class="color4"> </span></a></li>
                                <li><a href=""> <span class="color5"> </span></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="simpleCart_shelfItem">
                            <div class="price_single">
                                <div class="head"><h2><span class="amount item_price"><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" /> VNĐ</span></h2></div>
                                <div class="head_desc"><a href="#">12 reviews</a><img src="images/review.png" alt=""/></li></div>
                                <div class="clearfix"></div>
                            </div>
                            <!--<div class="single_but"><a href="" class="item_add btn_3" value=""></a></div>-->
                            <div class="size_2-right"><a href="Cart?product_id=${product.productId}&url=viewSingleProduct?productId=${product.productId}" class="item_add item_add1 btn_5" value="" />Thêm vào giỏ</a></div>

                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <!--                <div class="single_social_top">   
                                    <ul class="single_social">
                                        <li><a href="#"> <i class="s_fb"> </i> <div class="social_desc">Share<br> on facebook</div><div class="clearfix"> </div></a></li>
                                        <li><a href="#"> <i class="s_twt"> </i> <div class="social_desc">Tweet<br> this product</div><div class="clearfix"> </div></a></li>
                                        <li><a href="#"> <i class="s_google"> </i><div class="social_desc">Google+<br> this product</div><div class="clearfix"> </div></a></li>
                                        <li class="last"><a href="#"> <i class="s_email"> </i><div class="social_desc">Email<br> a Friend</div><div class="clearfix"> </div></a></li>
                                    </ul>
                                </div>-->
                <ul class="menu_drop">
                    <li class="item1"><a href="#"><img src="images/product_arrow.png">Thông tin chi tiết</a>
                        <ul>
                            <li class="subitem1"><a href="">${productDetail.information.replaceAll("#nl#", "<br>")} </a></li>
                            <li class="subitem2"><a href=""> </a></li>
                        </ul>
                    </li>
                    <li class="item2"><a href="#"><img src="images/product_arrow.png">Phụ kiện đi kèm</a>
                        <ul>
                            <li class="subitem1"><a href="#"> ${productDetail.accessories}</a></li>

                            <!--<li class="subitem1"><a href="#"> Chuột Asus ROG Sica</a></li>-->
                            <!--                            <li class="subitem1"><a href="#"> Tai nghe Gaming Razer P800</a></li>
                                                        <li class="subitem1"><a href="#"> Bàn phimms cơ Razer Z8000</a></li>-->
                        </ul>
                    </li>
                    <li class="item3"><a href="#"><img src="images/product_arrow.png">Bảo Hành</a>
                        <ul>
                            <li class="subitem1"><a href="">Bảo hành chính hãng 12 tháng</a></li>
                            <li class="subitem2"><a href="">Bảo hành cửa hàng 24 tháng</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <h3 class="m_2">Sản phẩm cùng hãng</h3>
            <div class="container">
                <div class="box_3">
                    <c:forEach var="productRl" items="${sameBrand}">
                        <div class="col-md-3">
                            <div class="content_box"><a href="viewSingleProduct?productId=${productRl.productId}">
                                    <img  width="225" height="225" src="${productRl.thumbImage}" alt="">
                                </a>
                            </div>
                            <h4><a href="viewSingleProduct?productId=${productRl.productId}">${productRl.name}</a></h4>
                            <p><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${productRl.price}" /> VNĐ</p>
                        </div>
                    </c:forEach>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <h3 class="m_2">Sản phẩm liên quan</h3>
            <div class="container">
                <div class="box_3">
                    <c:forEach var="productRl" items="${relatedProduct}">
                        <div class="col-md-3">
                            <div class="content_box"><a href="viewSingleProduct?productId=${productRl.productId}">
                                    <img  width="225" height="225" src="${productRl.thumbImage}" alt="">
                                </a>
                            </div>
                            <h4><a href="viewSingleProduct?productId=${productRl.productId}">${productRl.name}</a></h4>
                            <p><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${productRl.price}" /> VNĐ</p>
                        </div>
                    </c:forEach>
                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>
        <%@include file = "footer.jsp" %>
    </body>
</html>
