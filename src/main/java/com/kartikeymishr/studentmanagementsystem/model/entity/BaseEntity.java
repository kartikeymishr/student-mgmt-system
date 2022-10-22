package com.kartikeymishr.studentmanagementsystem.model.entity;

import com.kartikeymishr.studentmanagementsystem.firestore.DocumentId;

import java.util.Date;
import java.util.Objects;

public abstract class BaseEntity {

    @DocumentId
    private String entityId;
    private String firstName;
    private String lastName;
    private String email;
    private String registrationNumber;
    private String mobile;
    private Date dateOfBirth;

    public BaseEntity() {
    }

    public BaseEntity(String firstName, String lastName, String email, String registrationNumber, String mobile,
                      Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationNumber = registrationNumber;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName)
                && Objects.equals(email, that.email) && Objects.equals(registrationNumber, that.registrationNumber)
                && Objects.equals(mobile, that.mobile) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, registrationNumber, mobile, dateOfBirth);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", mobile='" + mobile + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
