package com.banana.entity;

import javax.persistence.*;

@Entity
@Table(name = "ordered_product", schema = "emarkett")
@IdClass(OrderedProductEntityPK.class)
public class OrderedProductEntity {
    private int orderId;
    private int productId;
    private Integer quantity;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProductEntity that = (OrderedProductEntity) o;

        if (orderId != that.orderId) return false;
        if (productId != that.productId) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + productId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
