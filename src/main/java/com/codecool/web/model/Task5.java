package com.codecool.web.model;

public class Task5 {
    private String company;
    private String products;
    private double price;

    public Task5(String company, String products, double price) {
        this.company = company;
        this.products = products;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getProducts() {
        return products;
    }

    public double getPrice() {
        return price;
    }
}
