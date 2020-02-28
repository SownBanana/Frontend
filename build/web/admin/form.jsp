<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- start: Meta -->
        <meta charset="utf-8">
        <title>Nhập sản phẩm</title>
        <link rel="SHORTCUT ICON" href="../images/logo.png">
        <meta name="description" content="Bootstrap Metro Dashboard">
        <meta name="author" content="Dennis Ji">
        <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <!-- end: Meta -->

        <!-- start: Mobile Specific -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- end: Mobile Specific -->

        <!-- start: CSS -->
        <link id="bootstrap-style" href="../css1/bootstrap.min.css" rel="stylesheet">
        <link href="../css1/bootstrap-responsive.min.css" rel="stylesheet">
        <link id="base-style" href="../css1/style.css" rel="stylesheet">
        <link id="base-style-responsive" href="../css1/style-responsive.css" rel="stylesheet">
        <link href="../font1/fontawesome-webfont-0.eot"/>;
        <link href="../font1/fontawesome-webfont-62877.eot"/>;
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>

        <link rel="shortcut icon" href="../img/favicon.ico">


    </head>

    <body>
        <%request.setCharacterEncoding("UTF-8");%>
        <%response.setCharacterEncoding("UTF-8");%>

        <div class="navbar">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="index.jsp"><span style="font-size: 38px"><b style="color: red">FIFTEEN</b> TECHNOLOGY</span><span style ="font-size: initial;">admin</span> </a>



                </div>
            </div>
        </div>


        <div class="container-fluid-full">
            <div class="row-fluid">

                <!-- start: Main Menu -->
                <div id="sidebar-left" class="span2">
                    <div class="nav-collapse sidebar-nav">
                        <ul class="nav nav-tabs nav-stacked main-menu">
                            <li><a href="form.jsp"><i class="icon-edit"></i><span class="hidden-tablet"> Thêm sản phẩm </span></a></li>
                            <li><a href="table.jsp"><i class="icon-align-justify"></i><span class="hidden-tablet"> Quản lý người dùng</span></a></li>
                            <li><a href="../login.jsp"><i class="icon-lock"></i><span class="hidden-tablet"> Đăng xuất</span></a></li>
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
                            <a href="index.jsp">Home</a>
                            <i class="icon-angle-right"></i> 
                        </li>
                        <li>
                            <i class="icon-edit"></i>
                            <a href="#">Forms</a>
                        </li>
                    </ul>




                    <%
                        String mess = request.getParameter("mess");
                        out.print("\n " + mess + "\n");
                    %>
                    <div class="row-fluid sortable">
                        <div class="box span12">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon white edit"></i><span class="break"></span>Thêm sản phẩm </h2>
                                <div class="box-icon">
                                    <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                    <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                                </div>
                            </div>
                            <div class="box-content">

                                <form class="form-horizontal" action="addProduct" method="post" enctype="multipart/form-data">
                                    <fieldset>
                                        <div class="control-group">
                                            <label class="control-label" for="prependedInput">Tên sản phẩm </label>
                                            <div class="controls">
                                                <div class="input-prepend">
                                                    <input id="prependedInput" size="16" type="text" name="name">
                                                </div>

                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="prependedInput">Tên chi tiết </label>
                                            <div class="controls">
                                                <div class="input-prepend">
                                                    <input id="prependedInput" size="16" type="text" name="description">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="prependedInput">Cấu hình </label>
                                            <div class="controls">
                                                <div class="input-prepend">
                                                    <input id="prependedInput" size="16" type="text" name="description_detail">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="appendedInput">Giá tiền</label>
                                            <div class="controls">
                                                <div class="input-append">
                                                    <input id="appendedInput" size="16" type="text" name="price">
                                                </div>

                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="appendedInput">Nhãn hiệu</label>
                                            <div class="controls">
                                                <div class="input-append">
                                                    <input id="appendedInput" size="16" type="text" name="brand">
                                                </div>

                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="appendedPrependedInput">Mô tả</label>
                                            <div class="controls">
                                                <div class="input-prepend input-append">
                                                    <input id="appendedPrependedInput"   size="16" type="text" name ="information" height="100px" width="400px" >
                                                </div>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="prependedInput">Phụ kiện</label>
                                            <div class="controls">
                                                <div class="input-prepend">
                                                    <input id="prependedInput" size="16" type="text" name="accessories">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="prependedInput">Bảo hành</label>
                                            <div class="controls">
                                                <div class="input-prepend">
                                                    <input id="prependedInput" size="16" type="text" name="guaranty">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label">Loại sản phẩm</label>
                                            <div class="controls">
                                                <select name="categoryId" path="brand">
                                                    <option value="1">Laptop</option>
                                                    <option value="2">Điện thoại</option>
                                                    <option value="3">Phụ kiện</option>

                                                </select>
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <p>Ảnh chính </p>
                                            <div class="controls">
                                                <input type="file" name="image"  multiple="true" >
                                            </div>
                                            <p>Ảnh mô tả 1 </p>
                                            <div class="controls">
                                                <input type="file" name ="image1" multiple="true">
                                            </div>
                                            <p>Ảnh mô tả 2 </p>
                                            <div class="controls">
                                                <input type="file" name ="image2" multiple="true">
                                            </div>
                                            <p>Ảnh mô tả 3 </p>
                                            <div class="controls">
                                                <input type="file" name ="image3" multiple="true">
                                            </div>
                                            <p>Ảnh mô tả 4 </p>
                                            <div class="controls">
                                                <input type="file" name ="image4" multiple="true">
                                            </div>
                                            <p>Ảnh mô tả 5 </p>
                                            <div class="controls">
                                                <input type="file" name ="image5" multiple="true">
                                            </div>
                                        </div>
                                        <%
//                                            String url = (String) request.getAttribute("file3");
%>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Lưu sản phẩm</button>
                                            <button class="btn" ><a href="form.jsp">Hủy</a></button>
                                        </div>
                                    </fieldset>
                                </form>
                            </div>
                        </div><!--/span-->

                    </div><!--/row-->


                </div><!--/.fluid-container-->

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
