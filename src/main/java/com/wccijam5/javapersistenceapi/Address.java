package com.wccijam5.javapersistenceapi;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String street;
    private String city;
    private String state;
    private String county;

    @OneToOne(mappedBy = "address")
    private Employee employee;
    protected Address(){}

    public Address(String street, String city, String state, String county) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.county = county;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
