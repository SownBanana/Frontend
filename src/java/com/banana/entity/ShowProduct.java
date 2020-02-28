package com.banana.entity;

import java.util.Date;


public class ShowProduct {
    private int order_id;
    private Date created;
    private String name;
    private int productId;
    private String image;
    
    public ShowProduct() {
    }

    @Override
    public String toString() {
        return "ShowProduct{" + "order_id=" + order_id + ", created=" + created + ", name=" + name + '}';
    }

    public ShowProduct(int order_id, Date created, String name) {
        this.order_id = order_id;
        this.created = created;
        this.name = name;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
