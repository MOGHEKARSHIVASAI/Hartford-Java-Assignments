package org.example;

public class Product {
    private int pid;
    private String name;
    private double price;
    private String brand;
    private String category;
    private int rating;
    private double discount;

    public Product(int pid, String name, double price, String brand, String category, int rating, double discount) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discount = discount;
    }

    // Getters and Setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
