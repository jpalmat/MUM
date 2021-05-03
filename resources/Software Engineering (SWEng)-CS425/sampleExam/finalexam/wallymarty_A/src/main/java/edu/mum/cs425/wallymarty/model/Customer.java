package edu.mum.cs425.wallymarty.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    public void setCoutry(String coutry) {
        this.country = coutry;
    }

    public Customer(String customerNumber, String name, String coutry, int contctPhoneNUmber, @NotNull(message = "please enter correct  Birth date") LocalDate dateOfBirth) {
        this.customerNumber = customerNumber;

        this.name = name;
        this.country = coutry;
        this.contctPhoneNUmber = contctPhoneNUmber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCoutry() {
        return country;
    }

    private String customerNumber;

    private String name;

    private String country;

    //    @Pattern(regexp = "^[0-9][0-9]{2}-[0-9]{2}-[0-9]{4}$11", message="Telephone Numbers must use numbers in this format: XXX-YY-ZZZZ")
    private int contctPhoneNUmber;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContctPhoneNUmber(int contctPhoneNUmber) {
        this.contctPhoneNUmber = contctPhoneNUmber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public int getContctPhoneNUmber() {
        return contctPhoneNUmber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", contctPhoneNUmber=" + contctPhoneNUmber +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @NotNull(message = "please enter correct  Birth date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;


}
