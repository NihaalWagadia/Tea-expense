package com.example.nihaa_000.chaiwalla;

import java.util.ArrayList;

public class TPrice {

    String name;
    int teaId;
    int fprice;
    int hprice;

    public TPrice(String name, int fprice, int hprice){
        this.name = name;
        this.hprice = hprice;
        this.fprice = fprice;

    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public int getFprice() {
        return fprice;
    }

    public void setFprice(int fprice) {
        this.fprice = fprice;
    }

    public int getHprice() {
        return hprice;
    }

    public void setHprice(int hprice) {
        this.hprice = hprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
