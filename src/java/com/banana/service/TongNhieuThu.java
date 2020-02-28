package com.banana.service;

import com.banana.dao.CustomerDAO;
import com.banana.dao.CustomerOrderDAO;
import com.banana.dao.ProductDAO;

/**
 *
 * @author DELL
 */
public class TongNhieuThu {
    public int tongSanPham(){
       return new ProductDAO().getAllProduct().size();
    }
    public  int tongDonDaBan(){
        return  new CustomerOrderDAO().getAllOrderCustomer().size();
    }
    
    public  int tongUser(){
        return  new CustomerDAO().getAllCustomer().size();
    }
    
    
    
    public static void main(String[] args) {
        int c =new TongNhieuThu().tongSanPham();
        System.out.println(c);
    }
}
