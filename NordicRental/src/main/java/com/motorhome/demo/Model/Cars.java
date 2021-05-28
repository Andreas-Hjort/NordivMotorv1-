package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cars {

    @Id
    private int id_cars;
    private String brand;
    private String model;
    private int beds;
    private int odometer;
    private double price;
    private Boolean status;
    private Boolean cleaning;
    private Boolean service;
    private String type;

    public Cars(){

    }


    public Cars(int id_cars, String brand, String model, int beds, int odometer, double price, Boolean status, Boolean cleaning, Boolean service, String type) {
        this.id_cars = id_cars;
        this.brand = brand;
        this.model = model;
        this.type = type;
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

    public int getId_cars() {
        return id_cars;
    }

    public void setId_cars(int id_cars) {
        this.id_cars = id_cars;
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

    public String getType(){return type;}

    public void setType(String type){this.type = type;}

}
