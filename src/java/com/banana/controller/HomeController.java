//package com.banana.controller;
//
//import com.banana.dao.ProductDAO;
//import com.banana.dao.ProductDetailDAO;
//import com.banana.entity.ProductDetailEntity;
//import com.banana.entity.ProductEntity;
//import com.sun.faces.action.RequestMapping;
//import org.springframework.stereotype.Controller;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.util.List;
//
//@Controller
//public class HomeController {
//    ProductDAO productDAO = new ProductDAO();
//    ProductDetailDAO productDetailDAO = new ProductDetailDAO();
//
//    //chuoi code
//    @RequestMapping(value = "/lastedProduct")
//    public String viewLastedProduct(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//
//        List<ProductEntity> products = productDAO.viewAllProduct(0, 3);
//        req.setAttribute("lastedProducts", products);
//        return "index";
//    }
//
//    //Xem tất cả sản phẩm (có ngắt trang)
//    @RequestMapping(value = "/viewAllProduct")
//    public String viewAllProduct(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//        int page = 1;
//        int recordsPerPage = 12;
//        if(req.getParameter("page") != null){
//            page = Integer.parseInt(req.getParameter("page"));
//        }
//        List<ProductEntity> products = productDAO.viewAllProduct((page - 1)*recordsPerPage, recordsPerPage);
//        int noOfRecords = productDAO.getNoOfRecords();
//        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//        req.setAttribute("productList", products);
//        req.setAttribute("noOfPages", noOfPages);
//        req.setAttribute("currentPage", page);
//        return "allProduct";
//    }
//
//    //Xem sản phẩm theo category (có ngắt trang)
//    @RequestMapping(value = "/viewProductByCategory")
//    public String viewProductByCategory(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//        int page = 1;
//        int recordsPerPage = 12;
//        if(req.getParameter("page") != null){
//            page = Integer.parseInt(req.getParameter("page"));
//        }
//        int category = Integer.parseInt(req.getParameter("category"));
//        List<ProductEntity> products = productDAO.viewAllProductByCategory((page - 1)*recordsPerPage, recordsPerPage,
//                category);
//        int noOfRecords = productDAO.getNoOfRecords();
//        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
//        req.setAttribute("productList", products);
//        req.setAttribute("noOfPages", noOfPages);
//        req.setAttribute("currentPage", page);
//        return "productByCategory";
//    }
//
//    //Xem từng sản phẩm
//    @RequestMapping(value = "/viewSingleProduct")
//    public String viewSingleProduct(HttpServletRequest request, HttpServletResponse response){
//        Integer productId = Integer.parseInt(request.getParameter("productId"));
//        ProductEntity product = productDAO.getProduct(productId);
//        ProductDetailEntity productDetail = productDetailDAO.getProductDetail(productId);
//        List<ProductEntity> relatedProducts = productDAO.viewAllProductByCategory(0, 5, 1);
//        relatedProducts.remove(product);
//        request.setAttribute("productDetail", productDetail);
//        request.setAttribute("product", product);
//        request.setAttribute("relatedProduct", relatedProducts);
//        return "single";
//    }
//    //Thêm sản phẩm
//    @RequestMapping(value = "/addProduct")
//    public String addProduct(HttpServletRequest request, HttpServletResponse response){
//        String name = request.getParameter("name");
//        Double price = Double.parseDouble(request.getParameter("price"));
//        String description = request.getParameter("description");
//        String descriptionDetail = request.getParameter("description_detail");
//        String image = request.getParameter("image");
//        String thumbImage = request.getParameter("thumbImage");
//        Integer categoryID = Integer.parseInt(request.getParameter("categoryId"));
//        String brand = request.getParameter("brand");
//        System.out.println(productDAO.insertProduct(name, price, description, descriptionDetail, image, thumbImage,
//                categoryID, brand));
//
//        String information = request.getParameter("information");
//        String image1 = request.getParameter("image1");
//        String image2 = request.getParameter("image2");
//        String image3 = request.getParameter("image3");
//        String image4 = request.getParameter("image4");
//        String image5 = request.getParameter("image5");
//        String accessories = request.getParameter("accessories");
//        String guaranty = request.getParameter("guaranty");
//        ProductEntity product = productDAO.getProduct(name, image);
//        Integer productId = product.getProductId();
//        System.out.println(productDetailDAO.insertProductDetail(productId, information, image1, image2, image3, image4
//                , image5,
//                accessories, guaranty));
//        return "addProduct";
//    }
//
//    //Lọc sản phẩm theo hãng (có ngắt trang)
//    @RequestMapping(value = "/viewProductsByBrand")
//    public String viewProductsByBrand(HttpServletRequest request, HttpServletResponse response){
//        int page = 1;
//        int recordsPerPage = 12;
//        if(request.getParameter("page") != null){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        String brand = request.getParameter("brand");
//        Integer categoryId = 0;
//        categoryId = Integer.parseInt(request.getParameter("category_id"));
//        if(categoryId == 0){
//            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
//                    brand);
//            request.setAttribute("products", products);
//            return "brandPage";
//        }
//        else{
//            List<ProductEntity> products = productDAO.viewAllProductByBrand((page - 1) * recordsPerPage, recordsPerPage,
//                    brand, categoryId);
//            request.setAttribute("products", products);
//            return "brandPagebyCategory";
//        }
//    }
//
//    //Lọc sản phẩm theo khoảng giá (có ngắt trang)
//    @RequestMapping(value = "/viewProductsByPrice")
//    public String viewProductsByPrice(HttpServletRequest request, HttpServletResponse response){
//        int page = 1;
//        int recordsPerPage = 12;
//        if(request.getParameter("page") != null){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        Double minPrice = 0.0;
//        try{
//            minPrice = Double.parseDouble(request.getParameter("min_price"));
//        }catch (Exception e){
//            minPrice = 0.0;
//        }
//        Double maxPrice = 1000000000000.0;
//        try{
//            maxPrice = Double.parseDouble(request.getParameter("min_price"));
//        }catch (Exception e){
//            minPrice = 1000000000000.0;
//        }
//        String order = request.getParameter("order");
//        Integer categoryId = 0;
//        try{
//            categoryId = Integer.parseInt(request.getParameter("category_id"));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            categoryId = 0;
//        }
//        if(categoryId == 0){
//            List<ProductEntity> products = productDAO.viewAllProductByPrice((page - 1)*recordsPerPage, recordsPerPage,
//                    minPrice, maxPrice, order);
//            request.setAttribute("products", products);
//            return "byprice";
//        }
//        else{
//            List<ProductEntity> products = productDAO.viewAllProductByPrice((page - 1)*recordsPerPage, recordsPerPage,
//                    minPrice, maxPrice, order, categoryId);
//            request.setAttribute("products", products);
//            return "bypricewithcategory";
//        }
//
//    }
//    //Bộ lọc sản phẩm theo khoảng giá, loại, hãng, bổ xung nếu nghĩ ra
//    @RequestMapping(value = "/fillter")
//    public String fillterProducts(HttpServletRequest request, HttpServletResponse response){
//        int page = 1;
//        int recordsPerPage = 12;
//        if(request.getParameter("page") != null){
//            page = Integer.parseInt(request.getParameter("page"));
//        }
//        //giá
//        Double minPrice = 0.0;
//        try{
//            minPrice = Double.parseDouble(request.getParameter("min_price"));
//        }catch (Exception e){
//            minPrice = 0.0;
//        }
//        Double maxPrice = 1000000000000.0;
//        try{
//            maxPrice = Double.parseDouble(request.getParameter("min_price"));
//        }catch (Exception e){
//            minPrice = 1000000000000.0;
//        }
//        String order = request.getParameter("orderPrice");
//
//        //hãng
//        String brand = request.getParameter("brand");
//
//        //loại
//        Integer categoryId = 0;
//        try{
//            categoryId = Integer.parseInt(request.getParameter("category_id"));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            categoryId = 0;
//        }
//
//        List<ProductEntity> products = productDAO.fillterProducts((page - 1)*recordsPerPage, recordsPerPage,
//                    minPrice, maxPrice, order, categoryId, brand);
//        request.setAttribute("products", products);
//        return "fillter";
//    }
//
//    @RequestMapping(value = "/login")
//    public String Login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//        return "login";
//    }
//
//}
//
