package nl.danielle.cattery.payload.request;

import com.sun.istack.NotNull;

import java.time.LocalDate;

public class KittenRequest {
    @NotNull
    private String name;
    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private double weight;
    @NotNull
    private String breed;
    private String firstVaccination;
    private String secondVaccination;
    @NotNull
    private double breedPrice;
    private double firstVaccinationPrice;
    private double secondVaccinationPrice;

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

    public double getBreedPrice() {
        return breedPrice;
    }

    public void setBreedPrice(double breedPrice) {
        this.breedPrice = breedPrice;
    }

    public double getFirstVaccinationPrice() {
        return firstVaccinationPrice;
    }

    public void setFirstVaccinationPrice(double firstVaccinationPrice) {
        this.firstVaccinationPrice = firstVaccinationPrice;
    }

    public double getSecondVaccinationPrice() {
        return secondVaccinationPrice;
    }

    public void setSecondVaccinationPrice(double secondVaccinationPrice) {
        this.secondVaccinationPrice = secondVaccinationPrice;
    }
}
