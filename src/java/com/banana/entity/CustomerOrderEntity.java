package com.banana.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "customer_order", schema = "emarkett")
public class CustomerOrderEntity {
    private int orderId;
    private Integer amount;
    private Date dateCreated;
    private Integer confirmationNumber;
    private int customer_id;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date_created", nullable = true)
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "confirmation_number", nullable = true)
    public Integer getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(Integer confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderEntity that = (CustomerOrderEntity) o;
        return orderId == that.orderId &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(dateCreated, that.dateCreated) &&
                Objects.equals(confirmationNumber, that.confirmationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount, dateCreated, confirmationNumber);
    }

    @Override
    public String toString() {
        return "CustomerOrderEntity{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                ", confirmationNumber=" + confirmationNumber +
                ", customer_id=" + customer_id +
                '}';
    }
}
