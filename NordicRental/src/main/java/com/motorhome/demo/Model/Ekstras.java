package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ekstras {

    @Id
    private int idekstras;
    private String extratype;
    private double price_extras;


    public Ekstras() {

    }

    public Ekstras(int idekstras, String extratype, double price_extras) {
        this.idekstras = idekstras;
        this.extratype = extratype;
        this.price_extras = price_extras;
    }

    public int getIdekstras() {
        return idekstras;
    }

    public void setIdekstras(int idekstras) {
        this.idekstras = idekstras;
    }

    public String getExtratype() {
        return extratype;
    }

    public void setExtratype(String extratype) {
        this.extratype = extratype;
    }

    public double getPrice_extras() {
        return price_extras;
    }

    public void setPrice_extras(double price_extras) {
        this.price_extras = price_extras;
    }
}