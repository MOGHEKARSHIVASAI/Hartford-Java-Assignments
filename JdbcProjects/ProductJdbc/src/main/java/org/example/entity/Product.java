package org.example.entity;

public class Product {
    private int pid;
    private String pname;
    private double cost;
    private String brand;
    private String category;
    private int rating;
    private double discount;
    private String manufactureDate;

    public Product(int pid, String pname, double cost, String brand, String category, int rating, double discount, String manufactureDate) {
        this.pid = pid;
        this.pname = pname;
        this.cost = cost;
        this.brand = brand;
        this.category = category;
        this.rating = rating;
        this.discount = discount;
        this.manufactureDate = manufactureDate;
    }


    // Getters and setters

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
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

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", discount=" + discount +
                ", manufactureDate='" + manufactureDate + '\'' +
                '}';
    }
}
