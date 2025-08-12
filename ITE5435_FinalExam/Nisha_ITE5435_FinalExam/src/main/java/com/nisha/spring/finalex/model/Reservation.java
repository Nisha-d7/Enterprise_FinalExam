package com.nisha.spring.finalex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reservations")
public class Reservation {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int numberOfPassengers;
    private String travelClass; // Economy, Business
    private String phoneNumber;
    private String departureDate;

    private Customer customer;
    private Payment payment;

    public Reservation() {}

    public Reservation(String id, String firstName, String lastName, int numberOfPassengers,
                       String travelClass, String phoneNumber, String departureDate,
                       Customer customer, Payment payment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfPassengers = numberOfPassengers;
        this.travelClass = travelClass;
        this.phoneNumber = phoneNumber;
        this.departureDate = departureDate;
        this.customer = customer;
        this.payment = payment;
    }

    // Getters and Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public int getNumberOfPassengers() { return numberOfPassengers; }
    public void setNumberOfPassengers(int numberOfPassengers) { this.numberOfPassengers = numberOfPassengers; }

    public String getTravelClass() { return travelClass; }
    public void setTravelClass(String travelClass) { this.travelClass = travelClass; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getDepartureDate() { return departureDate; }
    public void setDepartureDate(String departureDate) { this.departureDate = departureDate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Payment getPayment() { return payment; }
    public void setPayment(Payment payment) { this.payment = payment; }
}
