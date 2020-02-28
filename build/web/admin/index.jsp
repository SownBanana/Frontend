
<%@page import="com.banana.service.TongNhieuThu"%>
<%@page import="com.banana.dao.OrderedProductDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>Quản lý 15Tech Shop</title>
        <link rel="SHORTCUT ICON" href="../images/logo.png">
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <link id="bootstrap-style" href="../css1/bootstrap.min.css" rel="stylesheet">
        <link href="../css1/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="../css1/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="../css1/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>

        <link rel="shortcut icon" href="../img/arrows-active.png">





    </head>

    <body>
        <%
            OrderedProductDAO orderedProductDAO = new OrderedProductDAO();
            String tongTien = String.format("%.0f", orderedProductDAO.getTotalEarning());
            TongNhieuThu tong = new TongNhieuThu();
            int tongSp = tong.tongSanPham();
            int tongDon = tong.tongDonDaBan();
            int tongUser = tong.tongUser();
            //Double tongtien = (Double) request.getAttribute("tongTien");
        %>

        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span> 
                    </a>
                    <a class="brand" href="index.jsp"><span style="font-size: 38px"><b style="color: red">FIFTEEN</b> TECHNOLOGY</span><span style ="font-size: initial;">admin</span> </a>

                    <!-- start: Header Menu -->
                    <div class="nav-no-collapse header-nav">
                        <ul class="nav pull-right">



                            <li class="dropdown">
                                <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                                    <i class="halflings-icon white user"></i> ADMIN
                                    <span class="caret"></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="dropdown-menu-title">
                                        <span>Cài đặt tài khoản</span>
                                    </li>
                                    <li><a href="#"><i class="halflings-icon user"></i> </a></li>
                                    <li><a href="../logout"><i class="halflings-icon off"></i> Đăng xuất</a></li>
                                </ul>
                            </li>

                        </ul>
                    </div>


                </div>
            </div>
        </div>


        <div class="container-fluid-full">
            <div class="row-fluid">


                <div id="sidebar-left" class="span2">
                    <div class="nav-collapse sidebar-nav">
                        <ul class="nav nav-tabs nav-stacked main-menu">
                            <li><a href="form.jsp"><i class="icon-edit"></i><span class="hidden-tablet"> Thêm sản phẩm </span></a></li>
                            <li><a href="table.jsp"><i class="icon-align-justify"></i><span class="hidden-tablet"> Quản lý người dùng</span></a></li>
                            <li><a href="../logout"><i class="icon-lock"></i><span class="hidden-tablet"> Đăng xuất</span></a></li>
                        </ul>
                    </div>
                </div>


                <noscript>
                <div class="alert alert-block span10">
                    <h4 class="alert-heading">Warning!</h4>
                    <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
                </div>
                </noscript>


                <div id="content" class="span10">

                    <div class="row-fluid">

                        <div class="span3 statbox purple" onTablet="span6" onDesktop="span3">

                            <div class="number">132<i class="icon-arrow-up"></i></div>
                            <div class="title">Số người truy cập </div>

                        </div>
                        <div class="span3 statbox green" onTablet="span6" onDesktop="span3">
                            <div class="number"><%=tongDon%><i class="icon-arrow-up"></i></div>
                            <div class="title">Số đơn hàng đã</div>

                        </div>
                        <div class="span3 statbox blue noMargin" onTablet="span6" onDesktop="span3">
                            <div class="number"><%=tongUser - 1%><i class="icon-arrow-up"></i></div>
                            <div class="title">Số lượng khách hàng</div>

                        </div>
                        <div class="span3 statbox yellow" onTablet="span6" onDesktop="span3">

                            <div class="number" style="font-size: 25px;"><%=tongTien%> VNĐ<i class="icon-arrow-down"></i></div>
                            <div class="title">Tổng tiền bán được</div>

                        </div>	

                    </div>		

                    <div class="row-fluid">

                        <div class="span8 widget blue" onTablet="span7" onDesktop="span8">

                            <div id="stats-chart2"  style="height:282px" ></div>

                        </div>

                        <div class="sparkLineStats span4 widget green" onTablet="span5" onDesktop="span4">

                            <ul class="unstyled">

                                <li><span class="sparkLineStats3"></span>
                                    Pageviews:
                                    <span class="number">781</span>
                                </li>
                                <li><span class="sparkLineStats4"></span>
                                    Pages / Visit:
                                    <span class="number">2,19</span>
                                </li>
                                <li><span class="sparkLineStats5"></span>
                                    Avg. Visit Duration:
                                    <span class="number">00:02:58</span>
                                </li>
                                <li><span class="sparkLineStats6"></span>
                                    Bounce Rate: <span class="number">59,83%</span>
                                </li>
                                <li><span class="sparkLineStats7"></span>
                                    % New Visits:
                                    <span class="number">70,79%</span>
                                </li>
                                <li><span class="sparkLineStats8"></span>
                                    % Returning Visitor:
                                    <span class="number">29,21%</span>
                                </li>

                            </ul>

                            <div class="clearfix"></div>

                        </div><!-- End .sparkStats -->

                    </div>






                    <!-- end: Content -->
                </div><!--/#content.span10-->
            </div><!--/fluid-row-->

            <div class="modal hide fade" id="myModal">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h3>Settings</h3>
                </div>
                <div class="modal-body">
                    <p>Here settings can be configured...</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn" data-dismiss="modal">Close</a>
                    <a href="#" class="btn btn-primary">Save changes</a>
                </div>
            </div>

            <div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-content">
                    <ul class="list-inline item-details">
                        <li><a href="http://themifycloud.com">Admin templates</a></li>
                        <li><a href="http://themescloud.org">Bootstrap themes</a></li>
                    </ul>
                </div>
            </div>

            <div class="clearfix"></div>

            <footer>

                <p>
                    <span style="text-align:left;float:left">&copy; 2013 <a href="http://themifycloud.com/downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>

                </p>

            </footer>

            <!-- start: JavaScript-->

            <script src="js/jquery-1.9.1.min.js"></script>
            <script src="js/jquery-migrate-1.0.0.min.js"></script>

            <script src="../js1/jquery-ui-1.10.0.custom.min.js"></script>

            <script src="../js1/jquery.ui.touch-punch.js"></script>

            <script src="../js1/modernizr.js"></script>

            <script src="../js1/bootstrap.min.js"></script>

            <script src="../js1/jquery.cookie.js"></script>

            <script src='../js1/fullcalendar.min.js'></script>

            <script src='../js1/jquery.dataTables.min.js'></script>

            <script src="../js1/excanvas.js"></script>
            <script src="../js1/jquery.flot.js"></script>
            <script src="../js1/jquery.flot.pie.js"></script>
            <script src="../js1/jquery.flot.stack.js"></script>
            <script src="../js1/jquery.flot.resize.min.js"></script>

            <script src="../js1/jquery.chosen.min.js"></script>

            <script src="../js1/jquery.uniform.min.js"></script>

            <script src="../js1/jquery.cleditor.min.js"></script>

            <script src="../js1/jquery.noty.js"></script>

            <script src="../js1/jquery.elfinder.min.js"></script>

            <script src="../js1/jquery.raty.min.js"></script>

            <script src="../js1/jquery.iphone.toggle.js"></script>

            <script src="../js1/jquery.uploadify-3.1.min.js"></script>

            <script src="../js1/jquery.gritter.min.js"></script>

            <script src="../js1/jquery.imagesloaded.js"></script>

            <script src="../js1/jquery.masonry.min.js"></script>

            <script src="../js1/jquery.knob.modified.js"></script>

            <script src="../js1/jquery.sparkline.min.js"></script>

            <script src="../js1/counter.js"></script>

            <script src="../js1/retina.js"></script>

            <script src="../js1/custom.js"></script>
            <!-- end: JavaScript-->

    </body>
</html>
