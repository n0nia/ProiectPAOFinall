package models;

import java.util.*;

public class Performance {
    private String title;
    private String director;
    private String type;
    private int length;  // minutes
    private Date date;
    private ArrayList<Seat> availableSeats;
    private int id;

    public Performance(String title, String director, String type, int length) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.length = length;
    }

    public Performance(String title, String director, String type, int length, ArrayList<Seat> availableSeats) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.length = length;
        this.availableSeats = availableSeats;
    }

    public Performance() {
        title = "";
        director = "";
        type = "";
        length = 0;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getType() {
        return type;
    }

    public int getLength() {
        return length;
    }

    public Date getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvailableSeats(ArrayList<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public ArrayList<Seat> getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String toString() {
        return type + ", " + title + ", " + date + ", " + length +" min, by " + director;
    }
}
