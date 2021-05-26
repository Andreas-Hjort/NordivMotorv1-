package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ekstras {

    @Id
    private int id;
    private double price;
    private int picnic_tables;
    private int beds;
    private int chairs;
    private int bike_racks;
    private int child_seats;


    public Ekstras(){

    }

    public Ekstras(int id,  double price, int picnic_tables, int beds, int chairs, int bike_racks, int child_seats) {
        this.id = id;
        this.price = price;
        this.picnic_tables = picnic_tables;
        this.beds = beds;
        this.chairs = chairs;
        this.bike_racks = bike_racks;
        this.child_seats = child_seats;


    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public int getPicnic_tables(){
        return picnic_tables;
    }

    public void setPicnic_tables(int picnic_tables){
        this.picnic_tables = picnic_tables;
    }

    public int getBeds(){
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getChairs() {
        return chairs;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }

    public int getBike_racks() {
        return bike_racks;

    }

    public void setBike_racks(int bike_racks) {
        this.bike_racks = bike_racks;
    }

    public int getChild_seats() {
        return child_seats;
    }

    public void setChild_seats(int child_seats) {
        this.child_seats = child_seats;
    }
}