package nl.danielle.cattery.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

//    @OneToOne(fetch = FetchType.LAZY,
//            mappedBy = "customer")
//    private Address address;

    @NotNull
    @Column
    private String email;

    @NotNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull
    @Column
    private String kids;

    @NotNull
    @Column(name = "other_pets")
    private String otherPets;

//    public Customer(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

//    public Customer(String firstName, String lastName, String dateOfBirth, String email, int phoneNumber, String kids, String otherPets) {
//    }
//
//    public Customer() {
//
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getKids() {
        return kids;
    }

    public void setKids(String kids) {
        this.kids = kids;
    }

    public String getOtherPets() {
        return otherPets;
    }

    public void setOtherPets(String otherPets) {
        this.otherPets = otherPets;
    }

//    public String getFullName() {
//        return this.getFirstName() + " " + this.getLastName();
//    }
//
//    public int getAge() {
//        return getAge(LocalDate.now());
//    }
//
//    public int getAge(LocalDate onDate) {
//        return calculateAge(this.dateOfBirth, onDate);
//    }
//
//    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
//        if ((birthDate != null) && (currentDate != null)) {
//            return Period.between(birthDate, currentDate).getYears();
//        } else {
//            return 0;
//        }
//    }
}
