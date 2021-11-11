package nl.danielle.cattery.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "kittens")
public class Kitten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @NotNull
    @Column
    private double weight;

    @NotNull
    @Column
    private String breed;

    @Column(name = "first_vaccination")
    private String firstVaccination;

    @Column(name = "second_vaccination")
    private String secondVaccination;

    @OneToOne(mappedBy = "kitten")
    private FileUpload fileUpload;

    @OneToOne(fetch = FetchType.LAZY,
            mappedBy = "kitten")
    private Price price;

    public Kitten(String name, LocalDate dateOfBirth, double weight, String breed, String firstVaccination, String secondVaccination) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.breed = breed;
        this.firstVaccination = firstVaccination;
        this.secondVaccination = secondVaccination;
    }

    public Kitten() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getFirstVaccination() {
        return firstVaccination;
    }

    public void setFirstVaccination(String firstVaccination) {
        this.firstVaccination = firstVaccination;
    }

    public String getSecondVaccination() {
        return secondVaccination;
    }

    public void setSecondVaccination(String secondVaccination) {
        this.secondVaccination = secondVaccination;
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
