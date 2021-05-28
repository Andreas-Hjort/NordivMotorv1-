package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ekstras {

    @Id
    private int idekstras;
    private String extratype;
    private double price;


    public Ekstras() {

    }

    public Ekstras(int idekstras, String extratype, double price) {
        this.idekstras = idekstras;
        this.extratype = extratype;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}