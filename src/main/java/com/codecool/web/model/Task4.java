package com.codecool.web.model;

import java.util.List;

public class Task4 {
    private String company;
    private List<Integer> orderId;

    public Task4(String company, List<Integer> orderId) {
        this.company = company;
        this.orderId = orderId;
    }

    public String getCompany() {
        return company;
    }

    public List<Integer> getOrderId() {
        return orderId;
    }
}
