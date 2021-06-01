package com.motorhome.demo.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Andreas Hjort, Viktor Prieme, Axel Gundelach og Daniel Benjamin Jones
 */

public class Contracts {

    private int id_contracts;
    private int IDcar;
    private int IDcustomer;
    private String date_of_Reserve;
    private String date_of_handIn;
    private double end_kilometer;
    private double total_price;
    private String IDPickUp;
    private int ID_ekstra;
    private boolean fuel;



    // Fields from Customer
    private String first_Name;
    private String last_Name;

    //Fields from Car
    private String model;
    private String brand;
    private String type_cars;
    private int odometer;
    private double price_cars;

    // Fields from Extras
    private String extratype;
    private double price_extra;

    //Dropoff
    private String address;
    private int zip;
    private int distance_in_kilometer;

    //Object references
    private Cars cars;
    private Ekstras ekstras;
    private Dropoff dropoff;

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public Ekstras getEkstras() {
        return ekstras;
    }

    public void setEkstras(Ekstras ekstras) {
        this.ekstras = ekstras;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public double getPrice_cars() {
        return price_cars;
    }

    public void setPrice_cars(double price_cars) {
        this.price_cars = price_cars;
    }

    public double getPrice_extra() {
        return price_extra;
    }

    public void setPrice_extra(double price_extra) {
        this.price_extra = price_extra;
    }


    public Contracts(){
    }

    public boolean getFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public int getOdometer() {
        return odometer;
    }

    public String getExtratype() {
        return extratype;
    }

    public void setExtratype(String extratype) {
        this.extratype = extratype;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType_cars() {
        return type_cars;
    }

    public void setType_cars(String type_cars) {
        this.type_cars = type_cars;
    }

    public int getId_contracts() {
        return id_contracts;
    }

    public void setId_contracts(int id_contracts) {
        this.id_contracts = id_contracts;
    }

    public int getIDcar() {
        return IDcar;
    }

    public void setIDcar(int IDcar) {
        this.IDcar = IDcar;
    }

    public int getIDcustomer() {
        return IDcustomer;
    }

    public void setIDcustomer(int IDcustomer) {
        this.IDcustomer = IDcustomer;
    }

    public String getDate_of_Reserve() {
        return date_of_Reserve;
    }

    public void setDate_of_Reserve(String date_of_Reserve) {
        this.date_of_Reserve = date_of_Reserve;
    }

    public String getDate_of_handIn() {
        return date_of_handIn;
    }

    public void setDate_of_handIn(String date_of_handIn) {
        this.date_of_handIn = date_of_handIn;
    }


    public double getEnd_kilometer() {
        return end_kilometer;
    }

    public void setEnd_kilometer(double end_kilometer) {
        this.end_kilometer = end_kilometer;
    }



    public String getIDPickUp() {
        return IDPickUp;
    }

    public void setIDPickUp(String IDPickUp) {
        this.IDPickUp = IDPickUp;
    }


    public int getID_ekstra() {
        return ID_ekstra;
    }

    public void setID_ekstra(int ID_ekstra) {
        this.ID_ekstra = ID_ekstra;
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

    public int getDistance_in_kilometer() {
        return distance_in_kilometer;
    }

    public void setDistance_in_kilometer(int distance_in_kilometer) {
        this.distance_in_kilometer = distance_in_kilometer;
    }


    public Dropoff getDropoff() {
        return dropoff;
    }

    public void setDropoff(Dropoff dropoff) {
        this.dropoff = dropoff;
    }
}

