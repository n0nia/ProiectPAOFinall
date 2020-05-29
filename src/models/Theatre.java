package models;

import java.util.ArrayList;

public class Theatre {
    private ArrayList<Seat> seats;
    private static Theatre theatre = null;


    private Theatre() {}

    public ArrayList<Seat> getSeats() {
        seats = new ArrayList<Seat>();
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Standard(i, 1);
            seats.add(newSeat);
        }
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Standard(i, 2);
            seats.add(newSeat);
        }
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Balcony(i, 1);
            seats.add(newSeat);
        }
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Balcony(i, 2);
            seats.add(newSeat);
        }
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Loge(i, 1);
            seats.add(newSeat);
        }
        for (int i = 0; i < 6; i++) {
            Seat newSeat = new Balcony(i, 2);
            seats.add(newSeat);
        }
        return seats;
    }


    public static Theatre getTheatre() {
        if (theatre == null)
            theatre = new Theatre();
        return theatre;
    }
}
