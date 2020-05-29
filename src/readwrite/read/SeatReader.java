package readwrite.read;

import models.Balcony;
import models.Loge;
import models.Seat;
import models.Standard;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import static org.graalvm.compiler.options.OptionType.User;

public class SeatReader extends Reader<Seat> {

    private static List<Seat> seatList = new ArrayList<>();

    public static void readData() {

        SeatReader seatReader = new SeatReader();

        seatList = seatReader.readAndCreateObjects(
                "F:\\FMI\\Anul_II\\Sem_2\\PAO\\Proiect-PAO-master\\src\\readwrite\\resources\\Seats.csv");

        for (Seat client : seatList) {
            System.out.println(client);
        }
    }

    public static List<Seat> getSeatList() {
        return Collections.unmodifiableList(seatList);
    }

    @Override
    Seat createObject(String[] objectDetails) {
        if (objectDetails[2].equals("Standard")) {
            return new Standard(Integer.parseInt(objectDetails[0]), Integer.parseInt(objectDetails[1]), objectDetails[2]);
        } else if (objectDetails[2].equals("Balcony")) {
            return new Balcony(Integer.parseInt(objectDetails[0]), Integer.parseInt(objectDetails[1]), objectDetails[2]);
        } else if (objectDetails[2].equals("Loge")) {
            return new Loge(Integer.parseInt(objectDetails[0]), Integer.parseInt(objectDetails[1]), objectDetails[2]);
        }
        return new Standard(-1, -1, "invalidSeat");
    }
}