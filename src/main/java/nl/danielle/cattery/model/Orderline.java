package nl.danielle.cattery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import nl.danielle.cattery.payload.OrderlineCustomRequest;

import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class Orderline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "amount")
    private int amount;

    @Column
    private double price;

    @Column
    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "catpart_id")
    private Catpart catpart;

    public Orderline(){
    }

    public Orderline(Catpart catpart, int amount) {
        this.catpart = catpart;
        this.amount = amount;
        price = catpart.getPrice();
        description = catpart.getDescription();
    }

    public Orderline(String description, int amount, double price){
        this.description = description;
        this.amount = amount;
        this.price = price;
    }

    public Orderline(OrderlineCustomRequest orderlineCustomRequest){
        this.amount = orderlineCustomRequest.getAmount();
        this.description = orderlineCustomRequest.getDescription();
        this.price = orderlineCustomRequest.getPrice();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Catpart getCatpart() {
        return catpart;
    }

    public void setCatpart(Catpart catpart) {
        this.catpart = catpart;
    }
}
