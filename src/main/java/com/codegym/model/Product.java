package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String price;
    private String img;
    private String description;
    private String author;

    public Product() {
    }

    public Product(int id, String name, String price, String img, String description, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}