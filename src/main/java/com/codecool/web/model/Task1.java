package com.codecool.web.model;

public class Task1 {
    private String product;
    private String company;

    public Task1(String product, String company) {
        this.product = product;
        this.company = company;
    }

    public String getProduct() {
        return product;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Task1{" +
            "product='" + product + '\'' +
            ", company='" + company + '\'' +
            '}';
    }
}
