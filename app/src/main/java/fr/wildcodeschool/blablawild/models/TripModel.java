package fr.wildcodeschool.blablawild.models;

import java.util.Date;

public class TripModel {
    private String  firstName;
    private String  lastName;
    private Date    date;
    private int     price;

    public TripModel(String firstName, String lastName, Date date, int price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
