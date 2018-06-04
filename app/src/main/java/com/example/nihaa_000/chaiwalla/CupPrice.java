
package com.example.nihaa_000.chaiwalla;

        import java.util.ArrayList;

public class CupPrice {


    String name;
    int teaId;
    int solfhalf;
    int soldfull;

    public CupPrice(String name, int soldfull, int soldhalf){
        this.name = name;
        this.soldfull = soldfull;
        this.solfhalf = soldhalf;
    }

    public int getSolfhalf() {
        return solfhalf;
    }

    public void setSolfhalf(int solfhalf) {
        this.solfhalf = solfhalf;
    }

    public int getSoldfull() {
        return soldfull;
    }

    public void setSoldfull(int soldfull) {
        this.soldfull = soldfull;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
