package com.example.hhw.c2cshoping.bean;

public class CategoryBean {
    private String categoryText;
    private int categoryIcon;

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

    public void setCategoryIcon(int categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCategoryText() {

        return categoryText;
    }

    public int getCategoryIcon() {
        return categoryIcon;
    }

    public CategoryBean(String categoryText) {
        this.categoryText = categoryText;
    }

    public CategoryBean() {
    }

    public CategoryBean(String categoryText, int categoryIcon) {
        this.categoryText = categoryText;
        this.categoryIcon = categoryIcon;
    }
}
