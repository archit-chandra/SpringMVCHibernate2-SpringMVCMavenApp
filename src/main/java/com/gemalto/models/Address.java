package com.gemalto.models;

import javax.validation.constraints.NotNull;

public class Address {

    @NotNull(message = "country is required")
    private String country;

    @NotNull(message = "city is required")
    private String city;

    @NotNull(message = "street is required")
    private String street;

    @NotNull(message = "pincode is required")
    private Integer pincode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }
}
