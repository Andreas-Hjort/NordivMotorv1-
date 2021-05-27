package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ekstras {

    @Id
    private int idekstras;
    private String type;
    private double price;


    public Ekstras() {

    }

    public Ekstras(int idekstras, String type, double price) {
        this.idekstras = idekstras;
        this.type = type;
        this.price = price;
    }

    public int getIdekstras() {
        return idekstras;
    }

    public void setIdekstras(int idekstras) {
        this.idekstras = idekstras;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}