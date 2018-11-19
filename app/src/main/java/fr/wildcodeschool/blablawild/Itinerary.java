package fr.wildcodeschool.blablawild;

import java.io.Serializable;
import java.util.Date;

public class Itinerary implements Serializable {
    private String departure;
    private String destination;
    private Date date;

    public Itinerary(String departure, String destination, Date date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s>>%s", getDeparture(), getDestination());
    }
}
