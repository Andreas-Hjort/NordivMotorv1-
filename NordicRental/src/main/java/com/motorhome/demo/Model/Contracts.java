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
    private double start_kilometer;
    private double end_kilometer;
    private int price;
    private String IDPickUp;
    private String IDdropOff;

    public Contracts(){}

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

    public double getStart_kilometer() {
        return start_kilometer;
    }

    public void setStart_kilometer(double start_kilometer) {
        this.start_kilometer = start_kilometer;
    }

    public double getEnd_kilometer() {
        return end_kilometer;
    }

    public void setEnd_kilometer(double end_kilometer) {
        this.end_kilometer = end_kilometer;
    }

    public int getPrice() {
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

    public String getIDdropOff() {
        return IDdropOff;
    }

    public void setIDdropOff(String IDdropOff) {
        this.IDdropOff = IDdropOff;
    }
}

