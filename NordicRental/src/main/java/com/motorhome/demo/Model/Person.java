package com.motorhome.demo.Model;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

   @Id
    private int id;
    private String firstName;
    private String lastName;
    private int phone;
    private String mail;
    private String address;
    private int zip;

    public Person(){

    }

    public Person(int id, String firstName, String lastName, int phone, String mail, String address, int zip){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.mail = mail;
        this.address = address;
        this.zip = zip;
    }


    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
