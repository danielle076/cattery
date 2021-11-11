package nl.danielle.cattery.model;

import nl.danielle.cattery.payload.CustomerRequest;

import java.time.LocalDate;

public class CustomerBuilder {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String whichBreed;
    private String otherPets;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String homeTown;

    public CustomerBuilder(CustomerRequest customerRequest) {
        this.firstName = customerRequest.getFirstName();
        this.lastName = customerRequest.getLastName();
        this.dateOfBirth = customerRequest.getDateOfBirth();
        this.email = customerRequest.getEmail();
        this.phoneNumber = customerRequest.getPhoneNumber();
        this.whichBreed = customerRequest.getWhichBreed();
        this.otherPets = customerRequest.getOtherPets();
        this.streetName = customerRequest.getStreetName();
        this.houseNumber = customerRequest.getHouseNumber();
        this.postalCode = customerRequest.getPostalCode();
        this.homeTown = customerRequest.getHomeTown();
    }

    public Customer buildCustomer() {
        return new Customer(firstName, lastName, dateOfBirth, email, phoneNumber, whichBreed, otherPets);
    }

    public Address buildAddress() {
        return new Address(streetName, houseNumber, postalCode, homeTown);
    }
}
