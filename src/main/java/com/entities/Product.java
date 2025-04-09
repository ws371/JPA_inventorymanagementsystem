package com.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;
    private BigDecimal price;
    private int stockQuantity;
    private int reorderLevel;
    private String description;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @JsonIgnoreProperties("products")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", nullable = false)
    @JsonIgnoreProperties("products")
    private Supplier supplier;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId +
                ", productName=" + productName +
                ", categoryId=" + (category != null ? category.getCategoryId() : "null") +
                ", supplierId=" + (supplier != null ? supplier.getSupplierId() : "null") +
                ", price=" + price +
                ", stockQuantity=" + stockQuantity +
                ", reorderLevel=" + reorderLevel +
                ", description=" + description + "]";
    }
}