package com.example.hhw.c2cshoping.bean;

/* 商品id(唯一索引)   商品名     单价      邮费(是否包邮)       地址       剩余数量       售出多少件
 * 图片地址
 */

public class GoodsBean {
    private String goodsId ;
    private String picUrl1 ;
    private String picUrl2 ;
    private String picUrl3 ;
    private String goodsName ;
    private double Price ;
    private boolean isBaoyou ;
    private String address;
    private int lastNumber ;
    private int selledNumber ;

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public void setPicUrl1(String picUrl1) {
        this.picUrl1 = picUrl1;
    }

    public void setPicUrl2(String picUrl2) {
        this.picUrl2 = picUrl2;
    }

    public void setPicUrl3(String picUrl3) {
        this.picUrl3 = picUrl3;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setBaoyou(boolean baoyou) {
        isBaoyou = baoyou;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLastNumber(int lastNumber) {
        this.lastNumber = lastNumber;
    }

    public void setSelledNumber(int selledNumber) {
        this.selledNumber = selledNumber;
    }

    public String getGoodsId() {

        return goodsId;
    }

    public String getPicUrl1() {
        return picUrl1;
    }

    public String getPicUrl2() {
        return picUrl2;
    }

    public String getPicUrl3() {
        return picUrl3;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getPrice() {
        return Price;
    }

    public boolean isBaoyou() {
        return isBaoyou;
    }

    public String getAddress() {
        return address;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getSelledNumber() {
        return selledNumber;
    }
}
