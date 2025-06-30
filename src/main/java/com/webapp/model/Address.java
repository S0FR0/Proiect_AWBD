package com.webapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Strada este obligatorie")
    private String street;

    @NotBlank(message = "Orașul este obligatoriu")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Address() {}

    public Address(String street, String city, Person person) {
        this.street = street;
        this.city = city;
        this.person = person;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}