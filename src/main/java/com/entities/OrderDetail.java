package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_DETAIL_ID")
    private int orderDetailId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    @JsonIgnoreProperties("orderDetails")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonIgnoreProperties("orderDetails")
    private Product product;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    // Getters and setters

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + (order != null ? order.getOrderId() : null) +
                ", productId=" + (product != null ? product.getProductId() : null) +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
