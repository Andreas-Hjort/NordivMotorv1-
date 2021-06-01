package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @Author Daniel Benjamin Jones
 */

@Entity
public class Cars {

    @Id
    private int id_cars;
    private String brand;
    private String model;
    private int beds;
    private int odometer;
    private double price_cars;
    private Boolean status;
    private Boolean cleaning;
    private Boolean service;
    private String type_cars;

    public Cars(){

    }


    public Cars(int id_cars, String brand, String model, int beds, int odometer, double price_cars, Boolean status, Boolean cleaning, Boolean service, String type_cars) {
        this.id_cars = id_cars;
        this.brand = brand;
        this.model = model;
        this.type_cars = type_cars;
        this.beds = beds;
        this.odometer = odometer;
        this.price_cars = price_cars;
        this.status = status;
        this.cleaning = cleaning;
        this.service = service;

    }

    public double getPrice_cars() {
        return price_cars;
    }

    public void setPrice_cars(double price_cars) {
        this.price_cars = price_cars;
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

    public String getType_cars(){return type_cars;}

    public void setType_cars(String type_cars){this.type_cars = type_cars;}

}
