
package com.example.nihaa_000.chaiwalla;

        import java.util.ArrayList;

public class TeaTransaction {
    String name;
    int trans;


    public TeaTransaction(String name, int trans ) {
        this.name = name;
        this.trans = trans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getTrans() {
        return trans;
    }

    public void setTrans(int trans) {
        this.trans = trans;
    }


}