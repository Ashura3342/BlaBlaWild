package fr.wildcodeschool.blablawild.data;

import java.io.Serializable;
import java.util.Date;

public class ItineraryData implements Serializable {
    private String departure;
    private String destination;
    private Date date;

    public ItineraryData(String departure, String destination, Date date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
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

}
