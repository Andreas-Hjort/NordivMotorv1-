package com.motorhome.demo.Model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dropoff {
    
    @Id
    private int id;
    private String address; 
    private int zip;
    
    public Dropoff(){
    }

    public Dropoff(int id, String address, int zip) {
        this.id = id;
        this.address = address;
        this.zip = zip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
