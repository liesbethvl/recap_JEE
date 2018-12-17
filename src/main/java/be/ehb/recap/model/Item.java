package be.ehb.recap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank (message = "veld niet ingevuld")
    private String naam;

    @NotBlank (message = "veld niet ingevuld")
    private String omschrijving;

    @NotBlank (message = "veld niet ingevuld")
    private String userName;

    @NotBlank (message = "veld niet ingevuld")
    @Email(message = "email niet geldig")
    private String email;

    @NotNull (message = "veld niet ingevuld")
    @DecimalMin(value = "0.0", message= "bedrag moet positief zijn")
    private double vraagprijs;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVraagprijs() {
        return vraagprijs;
    }

    public void setVraagprijs(double vraagprijs) {
        this.vraagprijs = vraagprijs;
    }
}
