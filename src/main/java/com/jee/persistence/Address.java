package com.jee.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Address")
public class Address {
    @Id
    @GeneratedValue
    private long id;

    private String street1;

    private String city;

    private String street2;

    private String country;

    private  String zipCode;

    public Address(String street1, String city, String street2, String country, String zipCode) {
        this.street1 = street1;
        this.city = city;
        this.street2 = street2;
        this.country = country;
        this.zipCode = zipCode;
    }
    //constructors, getter and setter go here

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
