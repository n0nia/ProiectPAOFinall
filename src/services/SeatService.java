package services;

import models.Balcony;
import models.Loge;
import models.Seat;
import models.Standard;
import readwrite.write.Writer;

public class SeatService {
    private final Writer audit = new Writer();

    Seat getTypeOfSeat(String s) {
        Seat newSeat;
        audit.writeData("SeatService", "getTypwOfSeat");
        if (s.equals("StandardSeat")) {
            newSeat = new Standard();
        } else if (s.equals("Balcony")) {
            newSeat = new Balcony();
        } else if (s.equals("Loge")) {
            newSeat = new Loge();
        } else newSeat = new Standard();
        return newSeat;
    }




}
