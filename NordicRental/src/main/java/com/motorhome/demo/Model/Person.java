package com.motorhome.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

 @Id
 private int id_customer;
 private String first_Name;
 private String last_Name;
 private int phone;
 private String mail;
 private String address;
 private int zip;
 private int licensenr;
 private String licensedate;

 public Person(int id_customer, String first_Name, String last_Name, int phone, String mail, String address, int zip, int licensenr, String licensedate) {
  this.id_customer = id_customer;
  this.first_Name = first_Name;
  this.last_Name = last_Name;
  this.phone = phone;
  this.mail = mail;
  this.address = address;
  this.zip = zip;
  this.licensenr = licensenr;
  this.licensedate = licensedate;
 }

 public Person() {

 }

 public int getId_customer() {
  return id_customer;
 }

 public void setId_customer(int id_customer) {
  this.id_customer = id_customer;
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

 public int getLicensenr() {
  return licensenr;
 }

 public void setLicensenr(int licensenr) {
  this.licensenr = licensenr;
 }

 public String getLicensedate() {
  return licensedate;
 }

 public void setLicensedate(String licensedate) {
  this.licensedate = licensedate;
 }





}

