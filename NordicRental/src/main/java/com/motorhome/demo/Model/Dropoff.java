package com.motorhome.demo.Model;



import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Viktor Prieme
 */

@Entity
public class Dropoff {
    
    @Id
    private int id_dropoff;
    private String address; 
    private int zip;
    private double distance_in_kilometer;
    
    public Dropoff(){
    }

    public Dropoff(int id_dropoff, String address, int zip, double distance_in_kilometer) {
        this.id_dropoff = id_dropoff;
        this.address = address;
        this.zip = zip;
        this.distance_in_kilometer = distance_in_kilometer;
    }

    public int getId_dropoff() {
        return id_dropoff;
    }

    public void setId_dropoff(int id_dropoff) {
        this.id_dropoff = id_dropoff;
    }


    public double getDistance_in_kilometer() {
        return distance_in_kilometer;
    }

    public void setDistance_in_kilometer(double distance_in_kilometer) {
        this.distance_in_kilometer = distance_in_kilometer;
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

}
