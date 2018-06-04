package com.example.nihaa_000.chaiwalla;
public class ExpensePrice {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    String name;
    int price;


    public ExpensePrice(String name, int price){
        this.name = name;
        this.price = price;

    }



}
