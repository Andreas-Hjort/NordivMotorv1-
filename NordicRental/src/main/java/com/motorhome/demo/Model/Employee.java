package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id_employee;
    private String first_Name;
    private String last_Name;
    private int phone;
    private String mail;
    private String occupation;
    private String address;
    private String zip;

    public Employee(int id_employee, String first_Name, String last_Name, int phone, String mail, String occupation, String address, String zip) {
        this.id_employee = id_employee;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.phone = phone;
        this.mail = mail;
        this.occupation = occupation;
        this.address = address;
        this.zip = zip;
    }

    public Employee(){

    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}