package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "INVENTORY_TRANSACTION")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private int transactionId;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    @JsonIgnoreProperties("inventoryTransactions")
    private Product product;

    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "QUANTITY")
    private int quantity;

    // Getters and Setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InventoryTransaction{" +
                "transactionId=" + transactionId +
                ", product=" + (product != null ? product.getProductId() : null) +
                ", transactionDate=" + transactionDate +
                ", transactionType='" + transactionType + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
