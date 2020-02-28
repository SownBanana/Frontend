<%@page import="com.banana.dao.CustomerLvDAO"%>
<%@page import="com.banana.entity.CustomerLvEntity"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="com.banana.entity.CustomerEntity"%>
<%@page import="com.banana.dao.CustomerDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta charset="utf-8">
        <title>Quản lý người dùng</title>
        <link rel="SHORTCUT ICON" href="../images/logo.png">
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
              integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <!-- start: CSS -->
        <link id="bootstrap-style" href="../css1/bootstrap.min.css" rel="stylesheet">
        <link href="../css1/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="../css1/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="../css1/style-responsive.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>






    </head>

    <body>
        <%
            response.setContentType("text/html;charset=UTF-8");
            CustomerDAO customerDAO = new CustomerDAO();
            List<CustomerEntity> listCustomer = customerDAO.getAllCustomer();
            request.setAttribute("listCustomer", listCustomer);
        %>

        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">

                    <a class="brand" href="index.jsp"><span style="font-size: 38px"><b style="color: red">FIFTEEN</b> TECHNOLOGY</span><span style ="font-size: initial;">admin</span> </a>

                </div>
            </div>
        </div>
        <!-- start: Header -->

        <div class="container-fluid-full">
            <div class="row-fluid">

                <!-- start: Main Menu -->
                <div id="sidebar-left" class="span2">
                    <div class="nav-collapse sidebar-nav">
                        <ul class="nav nav-tabs nav-stacked main-menu">
                            <li><a href="form.jsp"><i class="icon-edit"></i><span class="hidden-tablet"> Thêm sản phẩm </span></a></li>
                            <li><a href="table.jsp"><i class="icon-align-justify"></i><span class="hidden-tablet"> Quản lý người dùng</span></a></li>
                            <li><a href="../logout"><i class="icon-lock"></i><span class="hidden-tablet"> Đăng xuất</span></a></li>
                        </ul>
                    </div>
                </div>
                <!-- end: Main Menu -->

                <noscript>
                <div class="alert alert-block span10">
                    <h4 class="alert-heading">Warning!</h4>
                    <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
                </div>
                </noscript>

                <!-- start: Content -->
                <div id="content" class="span10">


                    <ul class="breadcrumb">
                        <li>
                            <i class="icon-home"></i>
                            <a href="index.jsp">Trang chủ</a>
                            <i class="icon-angle-right"></i>
                        </li>
                        <li><a href="#">Quản lý người dùng</a></li>
                    </ul>

                    <div class="row-fluid sortable">		
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon white user"></i><span class="break"></span>Danh sách tài khoản </h2>
                                <div class="box-icon">
                                    <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                    <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>s
                                </div>
                            </div>
                            <div class="box-content">
                                <table class="table table-striped table-bordered bootstrap-datatable datatable">
                                    <thead>
                                        <tr>
                                            <th>Email</th>
                                            <th>Số điện thoại</th>
                                            <th>Tên</th>
                                            <th>Level</th>
                                            <th>Hoạt động </th>
                                        </tr>
                                    </thead>   
                                    <tbody>

                                        <c:forEach var="customer" items="${listCustomer}">
                                            <tr>
                                                <td>${customer.getEmail()}</td>
                                                <td class="center">${customer.getPhone()}</td>
                                                <td class="center">${customer.getName()}</td>
                                                <td class="center">
           
                                                    <span class="label label-success">${customer.getLevel()}</span>
                                                </td>
                                                <td class="center">

                                                    <a class="btn btn-success" href="../UpLv?id=${customer.getCustomerId()}">
                                                        Tăng Level
                                                    </a>
                                                    <a class="btn btn-info" href="../DownLv?id=${customer.getCustomerId()}">
                                                        Giảm Level
                                                    </a>

                                                </td>

                                            </tr>
                                        </c:forEach>



                                    </tbody>
                                </table>            
                            </div>
                        </div><!--/span-->

                    </div><!--/row-->





                </div><!--/.fluid-container-->

                <!-- end: Content -->
            </div><!--/#content.span10-->
        </div><!--/fluid-row-->


        <div class="clearfix"></div>



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
