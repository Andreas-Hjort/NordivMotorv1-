package com.motorhome.demo.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Contracts {

    @Id
    private int id;
    private int IDcar;
    private int IDcustomer;
    private String date_of_Reserve;
    private String date_of_handIn;
    private double end_kilometer;
    private double price;
    private String IDPickUp;
    private int IDekstra;


    // Fields from Customer
    private String first_Name;
    private String last_Name;

    //Fields from Car
    private String model;
    private String brand;
    private String type;
    private int odometer;

    // Fields from Extras
    private String extratype;

    //Dropoff
    private String address;
    private int zip;
    private int distance_in_kilometer;

    public Contracts(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getIDPickUp() {
        return IDPickUp;
    }

    public void setIDPickUp(String IDPickUp) {
        this.IDPickUp = IDPickUp;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIDekstra() {
        return IDekstra;
    }

    public void setIDekstra(int IDekstra) {
        this.IDekstra = IDekstra;
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

}

