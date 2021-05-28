package com.motorhome.demo.Model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dropoff {
    
    @Id
    private int id_dropoff;
    private String address; 
    private int zip;
    
    public Dropoff(){
    }

    public Dropoff(int id_dropoff, String address, int zip) {
        this.id_dropoff = id_dropoff;
        this.address = address;
        this.zip = zip;
    }

    public int getId() {
        return id_dropoff;
    }

    public void setId(int id_dropoff) {
        this.id_dropoff = id_dropoff;
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
