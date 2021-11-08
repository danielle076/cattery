package nl.danielle.cattery.model;

import nl.danielle.cattery.payload.KittenRequest;

import java.time.LocalDate;

public class KittenBuilder {

    //Kitten
    private String name;
    private LocalDate dateOfBirth;
    private double weight;
    private String breed;
    private String firstVaccination;
    private String secondVaccination;

    //Price
    private double breedPrice;
    private double firstVaccinationPrice;
    private double secondVaccinationPrice;

    public KittenBuilder(KittenRequest kittenRequest) {
        this.name = kittenRequest.getName();
        this.dateOfBirth = kittenRequest.getDateOfBirth();
        this.weight = kittenRequest.getWeight();
        this.breed = kittenRequest.getBreed();
        this.firstVaccination = kittenRequest.getFirstVaccination();
        this.secondVaccination = kittenRequest.getSecondVaccination();
        this.breedPrice = kittenRequest.getBreedPrice();
        this.firstVaccinationPrice = kittenRequest.getFirstVaccinationPrice();
        this.secondVaccinationPrice = kittenRequest.getSecondVaccinationPrice();
    }

    public Kitten buildKitten(){
        return new Kitten(name, dateOfBirth, weight, breed, firstVaccination, secondVaccination);
    }

    public Price buildPrice(){
        return new Price(breedPrice, firstVaccinationPrice, secondVaccinationPrice);
    }

}
