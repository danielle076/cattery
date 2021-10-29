package nl.danielle.cattery.model;


import nl.danielle.cattery.payload.RegisterUserRequest;

public class CustomerBuilder {

    //Customer
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private int phoneNumber;
    private String kids;
    private String otherPets;

    //Address
    private String streetName;
    private String houseNumber;
    private String houseNumberAddition;
    private String postalCode;
    private String homeTown;

    public CustomerBuilder(RegisterUserRequest registerUserRequest){
        this.firstName = registerUserRequest.getFirstName();
        this.lastName = registerUserRequest.getLastName();
        this.dateOfBirth = registerUserRequest.getDateOfBirth();
        this.email = registerUserRequest.getEmail();
        this.phoneNumber = registerUserRequest.getPhoneNumber();
        this.kids = registerUserRequest.getKids();
        this.otherPets = registerUserRequest.getOtherPets();
        this.streetName = registerUserRequest.getStreetName();
        this.houseNumber = registerUserRequest.getHouseNumber();
        this.postalCode = registerUserRequest.getPostalCode();
        this.homeTown = registerUserRequest.getHomeTown();
    }

    public CustomerBuilder withHousenumberAddition(RegisterUserRequest registerUserRequest){
        this.houseNumberAddition = registerUserRequest.getHouseNumberAddition();
        return this;
    }

    public Customer buildCustomer(){
        return new Customer(firstName, lastName, dateOfBirth, email, phoneNumber, kids, otherPets);
    }

    public Address buildAddress(){
        return new Address(streetName, houseNumber, houseNumberAddition, postalCode, homeTown);
    }
}
