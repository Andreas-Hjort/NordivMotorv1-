package com.motorhome.demo.Model;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Contracts {

    @Id
    private int IDcontract;
    private int IDcar;
    private int IDcustomer;
    private String dateOfReservation;
    private String dateOfHandIn;
    private double startOdometer;
    private double endOdometer;
    private int price;
    private String IDPickUp;
    private String IDdropOff;

    public Contracts(int IDcontract, int IDcar, int IDcustomer, String dateOfReservation, String dateOfHandIn, double startOdometer,
                     double endOdometer, int price, String IDPickUp, String IDdropOff) {
        this.IDcontract = IDcontract;
        this.IDcar = IDcar;
        this.IDcustomer = IDcustomer;
        this.dateOfReservation = dateOfReservation;
        this.dateOfHandIn = dateOfHandIn;
        this.startOdometer = startOdometer;
        this.endOdometer = endOdometer;
        this.price = price;
        this.IDPickUp = IDPickUp;
        this.IDdropOff = IDdropOff;
    }

    public Contracts(){}

    public int getIDcontract() {
        return IDcontract;
    }

    public void setIDcontract(int IDcontract) {
        this.IDcontract = IDcontract;
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

    public String getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(String dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public String getDateOfHandIn() {
        return dateOfHandIn;
    }

    public void setDateOfHandIn(String dateOfHandIn) {
        this.dateOfHandIn = dateOfHandIn;
    }

    public double getStartOdometer() {
        return startOdometer;
    }

    public void setStartOdometer(double startOdometer) {
        this.startOdometer = startOdometer;
    }

    public double getEndOdometer() {
        return endOdometer;
    }

    public void setEndOdometer(double endOdometer) {
        this.endOdometer = endOdometer;
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

