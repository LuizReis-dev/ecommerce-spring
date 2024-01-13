package com.luizreis.ecommerce.infrastructure.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipCode;
    private String country;
    private String state;
    private String city;
    private String street;
    private String complement;
    private String number;
    @OneToOne(mappedBy = "address")
    private CustomerEntity customer;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String zipCode, String country, String state, String city, String street, String complement, String number) {
        this.id = id;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
        this.number = number;
    }

    public AddressEntity(String zipCode, String country, String state, String city, String street, String complement, String number) {
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
