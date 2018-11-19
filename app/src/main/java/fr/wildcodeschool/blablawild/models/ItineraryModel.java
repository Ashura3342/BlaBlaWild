package fr.wildcodeschool.blablawild.models;

import java.io.Serializable;
import java.util.Date;

public class ItineraryModel implements Serializable {
    private String departure;
    private String destination;
    private Date date;

    public ItineraryModel() {
        this("", "", null);
    }

    public ItineraryModel(String departure, String destination, Date date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setdeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ItineraryModel{" +
                "departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }
}
