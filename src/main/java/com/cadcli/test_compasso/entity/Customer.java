package com.cadcli.test_compasso.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @ManyToOne @JoinColumn
    private City city;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public Customer() {
    }

    public Customer(long id, String name, Gender gender, City city, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.birthDate = birthDate;
    }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(){
        if (getBirthDate() != null) {
            return Period.between(getBirthDate(), LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
