<%-- 
    Document   : search
    Created on : Dec 15, 2019, 11:22:58 PM
    Author     : SownBanana
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>

        <title>15Tech Shop| <%= request.getAttribute("header")%> <%= request.getAttribute("search")%></title>
        <link rel="SHORTCUT ICON" href="images/logo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Homepage">

        <link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/sownindex.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <script type="application/x-javascript">
            addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
            }, false);

            function hideURLbar() {
            window.scrollTo(0, 1);
            }
        </script>

        <script src="js/simpleCart.min.js">
        </script>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>

    </head>
    <body>

        <%@include file="header.jsp" %>
        <div class="wrap-box"></div>
        <div class="content_top">
            <h3 class="m_1" style="margin-left: -36em;"><%= request.getAttribute("header")%></h3>
            <p class="m_1" style="margin-left: -36em;">100 - 300</p>
            <div class="container">
                <div class="box_1">
                    <div class="col-md-12">
                        <div class="section group">
                            <c:forEach var ="product" items="${products}">
                                <div class="col_1_of_3 span_1_of_5" style="margin-right: 0.8%; margin-left: 0.8%">
                                    <div class="shop-holder">
                                        <div class="product-img">
                                            <a href="viewSingleProduct?productId=${product.productId}">
                                                <img width="225" height="225" src="${product.thumbImage}" alt="item4"> </a>
                                                <c:if test="${ search eq null}">
                                                    <a href="Cart?product_id=${product.productId}&url=searchbrand?brand=<%= request.getAttribute("header")%>" class="button item_add"></a>
                                                </c:if>
                                                <c:if test="${ search ne null}">
                                                    <a href="Cart?product_id=${product.productId}&url=search?s=<%= request.getAttribute("search")%>" class="button item_add"></a>
                                                </c:if>
                                            
                                        </div>
                                    </div>
                                    <div class="shop-content" style="height: 80px;width: 225px;white-space: nowrap;overflow: hidden;">

                                        <h3><a class="name" href="viewSingleProduct?productId=${product.productId}">${product.name}</a></h3>
                                        <span class="amount item_price">Giá: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${product.price}" /> VNĐ</span>
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            
            <div class="botnext">
                <div class="next_page">

                    <c:if test="${currentPage != 1}" >

                        <a class="num direct" href="search?s=${s}&page=${currentPage - 1}"><i class="fa fa-caret-left" aria-hidden="true"></i></i></a>

                    </c:if>


                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <p class="active num">${i}</p>
                            </c:when>
                            <c:otherwise>
                                <p class="inactive num"><a href="search?s=${s}&page=${i}">${i}</a></p>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>



                    <c:if test="${currentPage lt noOfPages}">

                        <a class="num direct" href="search?s=${s}&page=${currentPage + 1}"><i class="fa fa-caret-right" aria-hidden="true"></i></a>

                    </c:if>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>



    </body>
</html>
