package com.shop.amazon.entities;

public class Product {
    private int id;
    private String type;
    private String title;
    private String desc;
    private String price;
    
    public Product(int id, String type, String title, String desc, String price) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }
    
    public Product() {
        super();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    

}
