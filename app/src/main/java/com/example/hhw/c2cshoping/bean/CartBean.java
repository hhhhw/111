package com.example.hhw.c2cshoping.bean;


import java.io.Serializable;


public class CartBean implements Serializable{
    private boolean isChecked = false;
    private String pic ;
    private String name ;
    private double price ;
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
