/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banana.model;

/**
 *
 * @author SownBanana
 */
public class Product {
    private int productID;
    private String name;
    private int quantity;
    private int price;
    private int categoryID;

    public Product() {
    }

    public Product(int productID, String name, int quantity, int price, int categoryID) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", categoryID=" + categoryID + '}';
    }
    
    
}
