package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cars {

    @Id
    private int id;
    private String brand;
    private String model;
    private int beds;
    private int odometer;
    private double price;
    private Boolean status;
    private Boolean cleaning;
    private Boolean service;

    public Cars(){

    }


    public Cars(int id, String brand, String model, int beds, int odometer, double price, Boolean status, Boolean cleaning, Boolean service) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.beds = beds;
        this.odometer = odometer;
        this.price = price;
        this.status = status;
        this.cleaning = cleaning;
        this.service = service;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getCleaning() {
        return cleaning;
    }

    public void setCleaning(Boolean cleaning) {
        this.cleaning = cleaning;
    }

    public Boolean getService() {
        return service;
    }

    public void setService(Boolean service) {
        this.service = service;
    }

}
