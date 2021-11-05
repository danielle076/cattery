package nl.danielle.cattery.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "kittens")
public class Kitten {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "date_born")
    private int dateBorn;

    @NotNull
    @Column
    private double weight;

    @NotNull
    @Column(name = "name_of_mother")
    private String nameOfMother;

    @NotNull
    @Column(name = "name_of_father")
    private String nameOfFather;

    @NotNull
    @Column(name = "family_tree")
    private String familyTree;

    @Column(name = "first_vaccination")
    private int firstVaccination;

    @Column(name = "second_vaccination")
    private int secondVaccination;

    @OneToOne(mappedBy = "kitten")
    private FileUpload fileUpload;

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

    public int getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(int dateBorn) {
        this.dateBorn = dateBorn;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNameOfMother() {
        return nameOfMother;
    }

    public void setNameOfMother(String nameOfMother) {
        this.nameOfMother = nameOfMother;
    }

    public String getNameOfFather() {
        return nameOfFather;
    }

    public void setNameOfFather(String nameOfFather) {
        this.nameOfFather = nameOfFather;
    }

    public String getFamilyTree() {
        return familyTree;
    }

    public void setFamilyTree(String familyTree) {
        this.familyTree = familyTree;
    }

    public int getFirstVaccination() {
        return firstVaccination;
    }

    public void setFirstVaccination(int firstVaccination) {
        this.firstVaccination = firstVaccination;
    }

    public int getSecondVaccination() {
        return secondVaccination;
    }

    public void setSecondVaccination(int secondVaccination) {
        this.secondVaccination = secondVaccination;
    }

    public FileUpload getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(FileUpload fileUpload) {
        this.fileUpload = fileUpload;
    }
}
