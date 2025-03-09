package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int SUPPLIER_ID;
    private String SUPPLIER_NAME;
    private String CONTACT_NAME;
    private String PHONE_NUMBER;
    private String EMAIL;
    private String ADDRESS;
    private String CITY;
    private String COUNTRY;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public int getSUPPLIER_ID() {
        return SUPPLIER_ID;}
    public void setSUPPLIER_ID(int SUPPLIER_ID) {
        this.SUPPLIER_ID = SUPPLIER_ID;}
    public String getSUPPLIER_NAME() {
        return SUPPLIER_NAME;}
    public void setSUPPLIER_NAME(String SUPPLIER_NAME) {
        this.SUPPLIER_NAME = SUPPLIER_NAME;}
    public String getCONTACT_NAME() {
        return CONTACT_NAME;}
    public void setCONTACT_NAME(String CONTACT_NAME) {
        this.CONTACT_NAME = CONTACT_NAME;}
    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;}
    public void setPHONE_NUMBER(String PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;}
    public String getEMAIL() {
        return EMAIL;}
    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;}
    public String getADDRESS() {
        return ADDRESS;}
    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;}
    public String getCITY() {
        return CITY;}
    public void setCITY(String CITY) {
        this.CITY = CITY;}
    public String getCOUNTRY() {
        return COUNTRY;}
    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;}
    public List<Product> getProducts() {
        return products;}
    public void setProducts(List<Product> products) {
        this.products = products;}

    public String toString() {
        return "Supplier [supplier_id=" + SUPPLIER_ID +
                ", supplier_name=" + SUPPLIER_NAME +
                ", contact_name=" + CONTACT_NAME +
                ", phone_number=" + PHONE_NUMBER +
                ", email=" + EMAIL +
                ", address=" + ADDRESS +
                ", city=" + CITY +
                ", country=" + COUNTRY + "]";
    }
}