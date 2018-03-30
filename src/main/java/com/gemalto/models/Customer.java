package com.gemalto.models;

import com.gemalto.validation.CourseCode;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Customer {

    @NotNull(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 char/digits")
    private String postalCode;

    // using our validator annotation without arguments and using the default values
//    @CourseCode
//    private String courseCode;

    // this time with some arguments
    @NotNull(message = "is required")
    @CourseCode(value = "TOP", message = "must start with TOP")
    private String courseCode;

    // when error message is passed as argument
//    @NotNull(message = "is required")
//    @Size(min = 2, max = 30, message = "size must be between {min} and {max}")
//    private String hobby;

    // when error message is not passed as argument. It will take from message properties file
    @NotNull(message = "is required")
    @Size(min = 2, max = 30)
    private String hobby;

    @Valid
    private Address address;

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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
