package com.banana.entity;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "customer_lv", schema = "emarkett", catalog = "")
public class CustomerLvEntity {
    private int customerId;
    private int level;
    private Integer discount;

    @Id
    @Column(name = "customer_id", nullable = false)
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Basic
    @Column(name = "discount", nullable = true)
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerLvEntity that = (CustomerLvEntity) o;
        return customerId == that.customerId &&
                level == that.level &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, level, discount);
    }

    @Override
    public String toString() {
        return "CustomerLvEntity{" +
                "customerId=" + customerId +
                ", level=" + level +
                ", discount=" + discount +
                '}';
    }
}
