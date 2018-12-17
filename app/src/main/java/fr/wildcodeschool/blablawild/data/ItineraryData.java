package fr.wildcodeschool.blablawild.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class ItineraryData implements Parcelable {
    private String departure;
    private String destination;
    private Date date;

    public ItineraryData(String departure, String destination, Date date) {
        this.departure = departure;
        this.destination = destination;
        this.date = date;
    }

    private ItineraryData(Parcel in) {
        this.departure = in.readString();
        this.destination = in.readString();
        this.date = new Date(in.readLong());
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.departure);
        dest.writeString(this.destination);
        dest.writeLong(this.date.getTime());
    }

    public static final Parcelable.Creator<ItineraryData> CREATOR
            = new Parcelable.Creator<ItineraryData>() {
        @Override
        public ItineraryData createFromParcel(Parcel source) {
            return new ItineraryData(source);
        }

        @Override
        public ItineraryData[] newArray(int size) {
            return new ItineraryData[size];
        }
    };
}
