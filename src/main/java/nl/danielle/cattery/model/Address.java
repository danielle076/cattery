//package nl.danielle.cattery.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.sun.istack.NotNull;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "address")
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @NotNull
//    @Column(name = "street_name")
//    private String streetName;
//
//    @NotNull
//    @Column(name = "house_number")
//    private String houseNumber;
//
//    @Column(name = "house_number_add")
//    private String houseNumberAddition;
//
//    @NotNull
//    @Column(name = "postal_code")
//    private String postalCode;
//
//    @NotNull
//    @Column(name = "home_town")
//    private String homeTown;
//
//    @JsonIgnore
//    @OneToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    public Address() {
//    }
//
//    public Address(String streetName, String houseNumber, String houseNumberAddition, String postalCode, String homeTown) {
//        this.streetName = streetName;
//        this.houseNumber = houseNumber;
//        this.houseNumberAddition = houseNumberAddition;
//        this.postalCode = postalCode;
//        this.homeTown = homeTown;
//        System.out.println("Address created");
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getStreetName() {
//        return streetName;
//    }
//
//    public void setStreetName(String streetName) {
//        this.streetName = streetName;
//    }
//
//    public String getHouseNumber() {
//        return houseNumber;
//    }
//
//    public void setHouseNumber(String houseNumber) {
//        this.houseNumber = houseNumber;
//    }
//
//    public String getHouseNumberAddition() {
//        return houseNumberAddition;
//    }
//
//    public void setHouseNumberAddition(String houseNumberAddition) {
//        this.houseNumberAddition = houseNumberAddition;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public String getHomeTown() {
//        return homeTown;
//    }
//
//    public void setHomeTown(String homeTown) {
//        this.homeTown = homeTown;
//    }
//}
