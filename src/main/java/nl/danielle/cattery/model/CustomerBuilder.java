package nl.danielle.cattery.model;

import nl.danielle.cattery.payload.RegisterCustomerRequest;

import java.time.LocalDate;

public class CustomerBuilder {

    //Customer
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    private String kids;
    private String otherPets;

    //Address
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String homeTown;

    public CustomerBuilder(RegisterCustomerRequest registerCustomerRequest){
        this.firstName = registerCustomerRequest.getFirstName();
        this.lastName = registerCustomerRequest.getLastName();
        this.dateOfBirth = registerCustomerRequest.getDateOfBirth();
        this.email = registerCustomerRequest.getEmail();
        this.phoneNumber = registerCustomerRequest.getPhoneNumber();
        this.kids = registerCustomerRequest.getKids();
        this.otherPets = registerCustomerRequest.getOtherPets();
        this.streetName = registerCustomerRequest.getStreetName();
        this.houseNumber = registerCustomerRequest.getHouseNumber();
        this.postalCode = registerCustomerRequest.getPostalCode();
        this.homeTown = registerCustomerRequest.getHomeTown();
    }

    public Customer buildCustomer(){
        return new Customer(firstName, lastName, dateOfBirth, email, phoneNumber, kids, otherPets);
    }

    public Address buildAddress(){
        return new Address(streetName, houseNumber, postalCode, homeTown);
    }
}
