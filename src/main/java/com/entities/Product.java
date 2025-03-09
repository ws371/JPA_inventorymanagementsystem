package com.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private BigDecimal PRICE;
    private int STOCK_QUANTITY;
    private int REORDER_LEVEL;
    private String DESCRIPTION;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID", nullable = false)
    private Supplier supplier;

    public Category getCategory() {
        return category;}
    public void setCategory(Category category) {
        this.category = category;}

    public Supplier getSupplier() {
        return supplier;}
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;}

    public int getPRODUCT_ID() {
        return PRODUCT_ID;}
    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;}
    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;}
    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;}
    public BigDecimal getPRICE() {
        return PRICE;}
    public void setPRICE(BigDecimal PRICE) {
        this.PRICE = PRICE;}
    public int getSTOCK_QUANTITY() {
        return STOCK_QUANTITY;}
    public void setSTOCK_QUANTITY(int STOCK_QUANTITY) {
        this.STOCK_QUANTITY = STOCK_QUANTITY;}
    public int getREORDER_LEVEL() {
        return REORDER_LEVEL;}
    public void setREORDER_LEVEL(int REORDER_LEVEL) {
        this.REORDER_LEVEL = REORDER_LEVEL;}
    public String getDESCRIPTION() {
        return DESCRIPTION;}
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;}

    public String toString() {
        return "Product [product_id=" + PRODUCT_ID +
                ", product_name=" + PRODUCT_NAME +
                ", category_id=" + category.getCATEGORY_ID() +
                ", supplier_id=" + supplier.getSUPPLIER_ID() +
                ", price=" + PRICE +
                ", stock_quantity=" + STOCK_QUANTITY +
                ", reorder_level=" + REORDER_LEVEL +
                ", description=" + DESCRIPTION + "]";
    }
}