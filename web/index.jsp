

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

    <head>

        <title>15Tech Shop| Mua cả thế giới mà bạn muốn qua chiếc Laptop của bạn</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Homepage">
        <link rel="SHORTCUT ICON" href="images/logo.png">
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
        <script type="text/javascript" src="js/megamenu.js"></script>
        <script type="text/javascript" src="js/scrollDiv.js"></script>
        <script>
            $(document).ready(function () {
                $(".megamenu").megamenu();
            });
        </script>

    </head>

    <body>

        <%@include file="header.jsp" %>

        <div class="wrap-box"></div>
        <div class="banner">
            <div class="container">
                <div class="banner_desc">
                    <h1>FIFTEEN TECHNOLOGY</h1>
                    <h2 style="    color: #fff;
                        text-transform: uppercase;
                        font-size: 1em;
                        font-weight: 650;
                        letter-spacing: 5px;">Mua cả thế giới mà bạn muốn </h2>
                    <div class="button">
                        <a href="#" class="hvr-shutter-out-horizontal">Mua Ngay</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="content_top">
            <h3 class="m_1" id="laptop">Laptop</h3>
            <div class="container">
                <div class="box_1">
                    <div class="col-md-12">
                        <div class="section group">
                            <c:forEach var ="product" items="${productsLap}">
                                <div class="col_1_of_3 span_1_of_5" style="margin-right: 0.8%; margin-left: 0.8%">
                                    <div class="shop-holder ">
                                        <div class="product-img">
                                            <a href="viewSingleProduct?productId=${product.productId}">
                                                <img width="225" height="225" src="${product.thumbImage}" alt="item4"> </a>
                                            <p class="hot_tag" style="color: white;
                                               font-size: 15px;
                                               position: absolute;
                                               background: url(images/sprite.png);
                                               background-position: -239px -62px;
                                               width: 45px;
                                               height: 45px;
                                               justify-content: center;
                                               align-items: center;
                                               display: flex;
                                               left: 0;
                                               top: 0;">HOT</p>
                                            <a href="Cart?product_id=${product.productId}" class="button item_add"></a>
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

                    <c:if test="${currentPageLap != 1}" >

                        <a class="num direct" href="index?pageLap=${currentPageLap - 1}&pagePhone=${currentPagePhone}&pageAcc=${currentPageAcc}"><i class="fa fa-caret-left" aria-hidden="true"></i></i></a>

                    </c:if>


                    <c:forEach begin="1" end="${noOfPagesLap}" var="i">
                        <c:choose>
                            <c:when test="${currentPageLap eq i}">
                                <p class="active num">${i}</p>
                            </c:when>
                            <c:otherwise>
                                <p class="inactive num"><a href="index?pageLap=${i}&pagePhone=${currentPagePhone}&pageAcc=${currentPageAcc}">${i}</a></p>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>



                    <c:if test="${currentPageLap lt noOfPagesLap}">

                        <a class="num direct" href="index?pageLap=${currentPageLap + 1}&pagePhone=${currentPagePhone}&pageAcc=${currentPageAcc}"><i class="fa fa-caret-right" aria-hidden="true"></i></a>

                    </c:if>
                </div>
            </div>
        </div>

        <div class="content_top">
            <h3 class="m_1" id="phone">Điện thoại</h3>
            <div class="container">
                <div class="box_1">
                    <div class="col-md-12">
                        <div class="section group">
                            <c:forEach var="product" items="${productsPhone}">
                                <div class="col_1_of_3 span_1_of_5"  style="margin-right: 0.8%; margin-left: 0.8%">
                                    <div class="shop-holder">
                                        <div class="product-img">
                                            <a href="viewSingleProduct?productId=${product.productId}">
                                                <img width="225" height="225" src="${product.thumbImage}" alt="item4"> </a>
                                            <p class="hot_tag" style="color: white;
                                               font-size: 15px;
                                               position: absolute;
                                               background: url(images/sprite.png);
                                               background-position: -239px -62px;
                                               width: 45px;
                                               height: 45px;
                                               justify-content: center;
                                               align-items: center;
                                               display: flex;
                                               left: 0;
                                               top: 0;">HOT</p>
                                            <a href="Cart?product_id=${product.productId}" class="button item_add"></a>
                                        </div>
                                    </div>
                                    <div class="shop-content" style="height: 80px;width: 225px;white-space: nowrap;overflow: hidden;">

                                        <h3><a href="viewSingleProduct?productId=${product.productId}">${product.name}</a></h3>
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

                    <c:if test="${currentPagePhone != 1}" >

                        <a class="num direct" href="index?pageLap=${currentPageLap}&pagePhone=${currentPagePhone - 1}&pageAcc=${currentPageAcc}"><i class="fa fa-caret-left" aria-hidden="true"></i></i></a>

                    </c:if>


                    <c:forEach begin="1" end="${noOfPagesPhone}" var="i">
                        <c:choose>
                            <c:when test="${currentPagePhone eq i}">
                                <p class="active num">${i}</p>
                            </c:when>
                            <c:otherwise>
                                <p class="inactive num"><a href="index?pageLap=${currentPageLap}&pagePhone=${i}&pageAcc=${currentPageAcc}">${i}</a></p>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>



                    <c:if test="${currentPagePhone lt noOfPagesPhone}">

                        <a class="num direct" href="index?pageLap=${currentPageLap}&pagePhone=${currentPagePhone + 1}&pageAcc=${currentPageAcc}"><i class="fa fa-caret-right" aria-hidden="true"></i></a>

                    </c:if>
                </div>
            </div>
        </div>

        <div class="content_top">
            <h3 class="m_1" id="acc">Phụ kiện</h3>
            <div class="container">
                <div class="box_1">
                    <div class="col-md-12">
                        <div class="section group">
                            <c:forEach var="product" items="${productsAcc}">
                                <div class="col_1_of_3 span_1_of_5" style="margin-right: 0.8%; margin-left: 0.8%">
                                    <div class="shop-holder">
                                        <div class="product-img">
                                            <a href="viewSingleProduct?productId=${product.productId}">
                                                <img width="225" height="225" src="${product.thumbImage}" alt="item4"> </a>
                                            <p class="hot_tag" style="color: white;
                                               font-size: 15px;
                                               position: absolute;
                                               background: url(images/sprite.png);
                                               background-position: -239px -62px;
                                               width: 45px;
                                               height: 45px;
                                               justify-content: center;
                                               align-items: center;
                                               display: flex;
                                               left: 0;
                                               top: 0;">HOT</p>
                                            <a href="Cart?product_id=${product.productId}" class="button item_add"></a>
                                        </div>
                                    </div>
                                    <div class="shop-content" style="height: 80px;width: 225px;white-space: nowrap;overflow: hidden;">

                                        <h3><a href="viewSingleProduct?productId=${product.productId}">${product.name}</a></h3>
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

                    <c:if test="${currentPageAcc != 1}" >

                        <a class="num direct" href="index?pageLap=${currentPageLap}&pagePhone=${currentPagePhone}&pageAcc=${currentPageAcc - 1}"><i class="fa fa-caret-left" aria-hidden="true"></i></i></a>

                    </c:if>


                    <c:forEach begin="1" end="${noOfPagesAcc}" var="i">
                        <c:choose>
                            <c:when test="${currentPageAcc eq i}">
                                <p class="active num">${i}</p>
                            </c:when>
                            <c:otherwise>
                                <p class="inactive num"><a href="index?pageLap=${currentPageLap}&pagePhone=${currentPagePhone}&pageAcc=${i}">${i}</a></p>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>



                    <c:if test="${currentPageAcc lt noOfPagesAcc}">

                        <a class="num direct" href="index?pageLap=${currentPageLap}&pagePhone=${currentPagePhone}&pageAcc=${currentPageAcc + 1}"><i class="fa fa-caret-right" aria-hidden="true"></i></a>

                    </c:if>
                </div>
            </div>
        </div>

        <div class="content_bottom">
            <div class="container">
                <h2 class="m_3">Sự Kiện Đang Diễn Ra</h2>
                <div class="grid_1">
                    <div class="col-md-6 blog_1">
                        <a href="#">
                            <div class="item-inner">
                                <img src="https://cafebiz.cafebizcdn.vn/thumb_w/640/2019/8/11/178a0914-15655299028751454688145-15655299614321067793079-crop-15655300047211502251751.png" class="img-responsive" alt="" />
                                <div class="date-comments">
                                    <div class="time"><span class="date"><span class="word1">28</span> <span class="word2">Tháng 12</span> </span>
                                    </div>
                                    <div class="comments">
                                        <span><span class="word1">0</span>
                                            <span class="word2">comment</span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-6 row_2">
                        <a href="#">
                            <div class="item-inner">
                                <img src="https://cafebiz.cafebizcdn.vn/thumb_w/640/2019/2019-thumb9c84d5f0-3a1f-448f-8795-3a88ff5a8e2e-15764882314461898812061-0-0-375-600-crop-1576488237731-637121793439357500.jpg" class="img-responsive" alt="" />
                                <div class="date-comments">
                                    <div class="time"><span class="date"><span class="word1">14</span> <span class="word2">Tháng 2</span> </span>
                                    </div>
                                    <div class="comments">
                                        <span><span class="word1">0</span>
                                            <span class="word2">comment</span></span>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>

    </body>

</html>