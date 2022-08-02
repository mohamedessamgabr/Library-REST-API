package com.essam.library.model;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_code")
    private int code;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_country")
    private String country;

    public Publisher() {
    }

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
