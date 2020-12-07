package com.entity;

public class state {
     private Integer id;
     private String name;
     private String abbreviation;
     private String capital;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public state() {
    }

    public state(Integer id, String name, String abbreviation, String capital) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.capital = capital;
    }
}
