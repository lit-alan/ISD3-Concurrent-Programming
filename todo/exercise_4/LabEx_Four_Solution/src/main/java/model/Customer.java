package model;

import java.time.LocalDate;

public class Customer {

    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private String paymentMethod;

    private String communicationPreferences;

    private String county;

    public Customer(Long customerId, String firstName, String lastName, String email, String password, String address, String phoneNumber, LocalDate dateOfBirth, String paymentMethod, String communicationPreferences, String county) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.paymentMethod = paymentMethod;
        this.communicationPreferences = communicationPreferences;
        this.county = county;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + "\t" +
                "Name: " + firstName + " " + lastName + "\t" +
                "Address: " + address + ", " + county + "\t" +
                "Date of Birth: " + dateOfBirth + "\t" +
                "Payment Method: " + paymentMethod + "\t" +
                "Email: " + email;
    }


    public Long getCustomerId() {
        return this.customerId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getCommunicationPreferences() {
        return this.communicationPreferences;
    }

    public String getCounty() {
        return this.county;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setCommunicationPreferences(String communicationPreferences) {
        this.communicationPreferences = communicationPreferences;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}