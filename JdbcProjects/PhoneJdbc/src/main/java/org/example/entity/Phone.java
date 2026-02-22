package org.example.entity;

public class Phone {
    private int id;
    private String name;
    private double cost;
    private String brand;
    private String category;

    public Phone(int id, String name, double cost, String brand, String category) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.brand = brand;
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
