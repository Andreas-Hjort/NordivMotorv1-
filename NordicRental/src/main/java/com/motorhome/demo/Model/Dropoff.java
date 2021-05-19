package com.motorhome.demo.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Dropoff {
    
    @Id
    private int id;
    private String address; 
    private int zip;
    private String date;
    
    public Dropoff(){
    }

    public Dropoff(int id, String address, int zip, String date) {
        this.id = id;
        this.address = address;
        this.zip = zip;
        this.date = date;
    }

    @javax.persistence.Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
