package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private int CATEGORY_ID;
    private String CATEGORY_NAME;
    private String DESCRIPTION;
    public int getCATEGORY_ID() {
        return CATEGORY_ID;}
    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;}
    public String getCATEGORY_NAME() {
        return CATEGORY_NAME;}
    public void setCATEGORY_NAME(String CATEGORY_NAME) {
        this.CATEGORY_NAME = CATEGORY_NAME;}
    public String getDESCRIPTION() {
        return DESCRIPTION;}
    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;}
    public String toString() {
        return "Category [category_id=" + CATEGORY_ID +
                ", category_name =" + CATEGORY_NAME + ", description=" + DESCRIPTION + "]";}
}

