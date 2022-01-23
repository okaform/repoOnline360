package com.cit360.week04;

import java.util.Arrays;

public class cityList {
    private int id;
    private String name;
    private String state;
    private String country;
    private double[] coord;

    //city ID
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    //City Name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    //State
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    //city's country
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    //city's coordinates
    public void setCoord(double[] coord) {
        this.coord = coord;
    }
    public double[] getCoord() {
        return coord;
    }

    @Override
    public String toString() {
        return "City Lists {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", coord=" + Arrays.toString(coord) +
                '}';
    }
}
