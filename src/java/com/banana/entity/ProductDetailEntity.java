package com.banana.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_detail", schema = "emarkett", catalog = "")
public class ProductDetailEntity {
    private int productId;
    private String information;
    private String image1;
    private String image2;
    private String image3;
    private String image4;
    private String image5;
    private String accessories;
    private String guaranty;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "information")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Basic
    @Column(name = "image1")
    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    @Basic
    @Column(name = "image2")
    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    @Basic
    @Column(name = "image3")
    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    @Basic
    @Column(name = "image4")
    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    @Basic
    @Column(name = "image5")
    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    @Basic
    @Column(name = "accessories")
    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    @Basic
    @Column(name = "guaranty")
    public String getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductDetailEntity that = (ProductDetailEntity) o;

        if (productId != that.productId) return false;
        if (information != null ? !information.equals(that.information) : that.information != null) return false;
        if (image1 != null ? !image1.equals(that.image1) : that.image1 != null) return false;
        if (image2 != null ? !image2.equals(that.image2) : that.image2 != null) return false;
        if (image3 != null ? !image3.equals(that.image3) : that.image3 != null) return false;
        if (image4 != null ? !image4.equals(that.image4) : that.image4 != null) return false;
        if (image5 != null ? !image5.equals(that.image5) : that.image5 != null) return false;
        if (accessories != null ? !accessories.equals(that.accessories) : that.accessories != null) return false;
        if (guaranty != null ? !guaranty.equals(that.guaranty) : that.guaranty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (information != null ? information.hashCode() : 0);
        result = 31 * result + (image1 != null ? image1.hashCode() : 0);
        result = 31 * result + (image2 != null ? image2.hashCode() : 0);
        result = 31 * result + (image3 != null ? image3.hashCode() : 0);
        result = 31 * result + (image4 != null ? image4.hashCode() : 0);
        result = 31 * result + (image5 != null ? image5.hashCode() : 0);
        result = 31 * result + (accessories != null ? accessories.hashCode() : 0);
        result = 31 * result + (guaranty != null ? guaranty.hashCode() : 0);
        return result;
    }
}
