package nl.danielle.cattery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "breed_price")
    private double breedPrice;

    @Column(name = "first_vaccination_price")
    private double firstVaccinationPrice;

    @Column(name = "second_vaccination_price")
    private double secondVaccinationPrice;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "kitten_id")
    private Kitten kitten;

    public Price() {

    }

    public Price(double breedPrice, double firstVaccinationPrice, double secondVaccinationPrice) {
        this.breedPrice = breedPrice;
        this.firstVaccinationPrice = firstVaccinationPrice;
        this.secondVaccinationPrice = secondVaccinationPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Kitten getKitten() {
        return kitten;
    }

    public void setKitten(Kitten kitten) {
        this.kitten = kitten;
    }

    public String getPrice() {
        return this.getBreedPrice() + " " + this.getFirstVaccinationPrice() + " " + this.getSecondVaccinationPrice();
    }
}
