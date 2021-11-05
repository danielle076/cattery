package nl.danielle.cattery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "files")
public class FileUpload {

    @Id
    @Column(nullable = false, unique = true)
    private String id = randomUUID().toString();

    private String name;

    private String type;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kitten_id", referencedColumnName = "id")
    private Kitten kitten;

    @JsonIgnore
    @Lob
    private byte[] data;

    public FileUpload() {
    }

    public FileUpload(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Kitten getKitten() {
        return kitten;
    }

    public void setKitten(Kitten kitten) {
        this.kitten = kitten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
